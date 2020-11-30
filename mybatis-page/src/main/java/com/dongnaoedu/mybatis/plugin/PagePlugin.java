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

@Intercepts(@Signature(
		type = StatementHandler.class, 
		method = "prepare", 
		args = {Connection.class, Integer.class}))
public class PagePlugin implements Interceptor {
	
	// 数据库类型, pagehleper , url = jdbc:mysql
	private static String dialect = "";
	
	// 分页关键字, .*ByPage$ = 已ByPage结尾的方法就进行分页
	private static String pageSqlId = "";

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		
		// 引入Mybatis已经实现了的对象：MetaObject,把StatementHandler的实例，变为MetaObject的实例
		MetaObject metaObject = MetaObject.forObject(statementHandler, 
				SystemMetaObject.DEFAULT_OBJECT_FACTORY,
				SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, 
				new DefaultReflectorFactory());
		
		// context.getBean("");
		MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
		// mapper 方法名
		String id = mappedStatement.getId();
		// 根据自定义标识匹配需要分页方法[以ByPage字符串结尾]
		if (id.matches(pageSqlId)) {
			
			// 获取sql的包装类BoundSql
			BoundSql boundSql = statementHandler.getBoundSql();
			
			Map<String, Object> params = (Map<String, Object>) boundSql.getParameterObject();
			if (params == null) {
				throw new NullPointerException("parameterObject error");
			} else {
				
				// 获取自定义分页参数对象
				PageInfo pageInfo = (PageInfo) params.get("page");
				
				// 拿到原始sql
				String sql = boundSql.getSql();
				
				// 原始sql封装：count
				String countSql = "select count(0) from (" + sql + ") a";
				System.out.println("总数sql 语句:" + countSql);
				
				// mybatis执行查询总数sql
				Connection connection = (Connection) invocation.getArgs()[0];
				
				// jdbc
				PreparedStatement countStatement = connection.prepareStatement(countSql);
				// 获取查询条件的参数
				ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
				// 经过set方法，就可以正确的执行sql语句
				parameterHandler.setParameters(countStatement);
				ResultSet rs = countStatement.executeQuery();
				// 当结果集中有值时，表示页面数量大于等于1 
				if (rs.next()) {
					pageInfo.setTotalNumber(rs.getInt(1));
				}
				rs.close();
				countStatement.close();
				
				// 原始sql封装：limit
				
				// 拼装分页sql
				// select * from user order by #{id} limit 0,5; 
				String pageSql = generatePageSql(sql, pageInfo);;
				System.out.println("分页sql 语句:" + pageSql);
				
				// MetaObject对象来替换原来的查询语句      
				metaObject.setValue("delegate.boundSql.sql", pageSql);
				
			}
			
		} 
		
		// 默认mybatis
		return invocation.proceed();
	}

	/**
	 * 生成分页sql   select * from user limit 0,5;
	 * @param sql
	 * @param pageInfo
	 * @return
	 */
	private String generatePageSql(String sql, PageInfo page) {
		StringBuffer pageSql = new StringBuffer();
		if ("mysql".equals(dialect)) {
			pageSql.append(sql);
			pageSql.append(" limit " + page.getStartIndex() + "," + page.getTotalSelect());
		} else if ("oracle".equals(dialect)) {
			
		} //.....
		return pageSql.toString();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		dialect = properties.getProperty("dialect");
		pageSqlId = properties.getProperty("pageSqlId");
	}

}
