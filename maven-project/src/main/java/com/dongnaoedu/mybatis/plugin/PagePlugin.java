package com.dongnaoedu.mybatis.plugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import com.dongnaoedu.mybatis.utils.PageInfo;

/**
 * mybaits拦截器的分页
 * 
 * @author allen
 *
 */
@Intercepts({
		@Signature(args = { Connection.class, Integer.class }, method = "prepare", type = StatementHandler.class) 
	})
public class PagePlugin implements Interceptor {
	
	// 数据库类型
	private static String dialect = "";
	
	// 分页关键字
	private static String pageSqlId = "";

	/**
	 * 拦截器需要执行的方法
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// 1. 确定什么样的方法需要分页和使用的数据库类型
		// 1. sql
		// 2. limit
		// 3. count
		
		// 从invocation拿到我们StatementHandler对象
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		BoundSql boundSql = statementHandler.getBoundSql();
		// 1.获取原始sql
		String sql = boundSql.getSql();
		System.out.println("原始sql 语句：" + sql);
		
		
		// mybatis已经实现对象，
		MetaObject metaObject = MetaObject.forObject(statementHandler, 
				SystemMetaObject.DEFAULT_OBJECT_FACTORY, 
				SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, 
				new DefaultReflectorFactory());
		
		MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
		String id = mappedStatement.getId();
		// 1. 
		// mapper文件中sql语句唯一id
		if (id.matches(pageSqlId)) {
			// 获取到我们sql对象
			
			// 2.要拿到参数
			Map<String, Object> params = (Map<String, Object>) boundSql.getParameterObject();
			if (params == null) {
				throw new NullPointerException("参数对象不能为空");
			} else {
				
				
				// map.put("page", new PageInfo(pageSize, pageNum));
				PageInfo pageInfo = (PageInfo) params.get("page");
				
				// 5.根据原始sql拼接我们的查询总数的sql
				String countSql =  "select count(0) from (" + sql + ") a";
				System.out.println("总数sql 语句：" + countSql);
				// 6.对5进行jdbc查询，得到我们结果
				
				Connection connection = (Connection) invocation.getArgs()[0];
				PreparedStatement countStatement = connection.prepareStatement(countSql);
				ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
				parameterHandler.setParameters(countStatement);
				ResultSet rs = countStatement.executeQuery();
				if (rs.next()) {
					pageInfo.setTotalNumber(rs.getInt(1));
				}
				rs.close();
				countStatement.close();
				
				// 4.根据原始拼接分页sql
				String pageSql = generatePageSql(sql, pageInfo);
				System.out.println("分页sql 语句：" + pageSql);
				
				// 7.把执行流程交给mybatis
				metaObject.setValue("delegate.boundSql.sql", pageSql);
			}
			
		}
		
		// 8.拦截器往下走
		return invocation.proceed();
	}
	
	/**
	 * 生成我们的分页sql，根据数据库类型
	 * @param sql
	 * @param pageInfo
	 * @return
	 */
	public String generatePageSql(String sql, PageInfo pageInfo) {
		if (pageInfo != null && (dialect != null || !dialect.equals(""))) {
			StringBuffer sb = new StringBuffer();
			if ("mysql".equals(dialect)) {
				sb.append(sql);
				sb.append(" limit " + pageInfo.getStartIndex() + " , " + pageInfo.getTotalSelect());
			} 
			
//			pagehelper
//			else if ("oracle".equals(dialect)) {
//				sb.append("oracle 分页方式")
//			}
			
			return sb.toString();
		} else {
			return sql;
		}
		
	}

	/**
	 * 拦截器需要拦截的对象
	 */
	@Override
	public Object plugin(Object target) {
		// 拦截器需要拦截的对象：targe, this:当前类的实例
		return Plugin.wrap(target, this);
	}

	/**
	 * 拿到我们在配置文件中配置的属性
	 */
	@Override
	public void setProperties(Properties properties) {
		dialect = properties.getProperty("dialect");
		pageSqlId = properties.getProperty("pageSqlId");
	}

}
