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

// mybatis插件机制- 分页

@Intercepts(value = {
		@Signature(args = { Connection.class, Integer.class }, method = "prepare", type = StatementHandler.class) 
	})
public class PagePlugin2 implements Interceptor {

	/**
	 * 拦截器需要执行的方法
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// 1. 确定那些方法需要分页 ByPage
		
		// 从invocation拿到我们StatementHandler对象
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		// 得到原始sql
		BoundSql boundSql = statementHandler.getBoundSql();
		String sql = boundSql.getSql();
		System.out.println("原始sql ： " + sql);
		
		// 获取我们分页参数：Map.put(PageInfo)
		Object paramObj = boundSql.getParameterObject();
		
		MetaObject metaObject = MetaObject.forObject(statementHandler, 
				SystemMetaObject.DEFAULT_OBJECT_FACTORY, 
				SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, 
				new DefaultReflectorFactory());	
		
		MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
		String mapperMethodName = mappedStatement.getId();
		
		if (mapperMethodName.matches(".*ByPage$")) {
			Map<String, Object> params = (Map<String, Object>) paramObj;
			PageInfo pageInfo = (PageInfo) params.get("page"); // map.put("page", PageInfo);
			
			// 2. select count 封装	  // SELECT COUNT(0) FROM USER;
			// SELECT COUNT(0) FROM (SELECT * FROM USER) a;
			String countSql = "select count(0) from (" + sql +") a";
			System.out.println("查询总数的sql : " + countSql);
			
			// mybatis执行一个jdbc操作
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
			
			// 3. select limit 封装		// SELECT * FROM USER LIMIT 0, 3;
			String pageSql = generaterPageSql(sql, pageInfo);
			System.out.println("分页sql : " + pageSql); //mybatispulugs pagehepeler
			
			// 把执行流程交给mybatis
			metaObject.setValue("delegate.boundSql.sql", pageSql);
		}
		
		return invocation.proceed();
	}
	
	
	// 根据数据库类型生成sql
	// SELECT * FROM USER LIMIT 0, 3;
	public String generaterPageSql(String sql , PageInfo pageInfo) {
		StringBuffer sb = new StringBuffer();
		sb.append(sql);
		sb.append(" limit " + pageInfo.getStartIndex() + " ," + pageInfo.getTotalSelect());
		return sb.toString();
	}
	
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	// 拿到插件的参数
	@Override
	public void setProperties(Properties properties) {
		// ...
	}

}
