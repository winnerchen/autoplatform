package yiheng.chen.interceptor;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import yiheng.chen.util.Paginator;



@Intercepts({
	@Signature(
		type = StatementHandler.class,
		method = "prepare",
		args = {Connection.class }
	) 
})
public class PageInterceptor implements Interceptor {

	private String pageSqlId;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// intercepted object
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		// get sqlid of the intercepted object through reflection
		MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY);
		MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
		// sqlid in config file
		String id = mappedStatement.getId();
		// if the sqlid match our regular expression
		if (id.matches(pageSqlId)) {
			BoundSql boundSql = statementHandler.getBoundSql();
			// original sql sentence
			String sql = boundSql.getSql();
			Map<?, ?> parameter = (Map<?, ?>) boundSql.getParameterObject();
			// proceed if parameter is not null
			if (parameter != null) {
				Paginator paginator = (Paginator) parameter.get("paginator");
				// transform to paging sql sentence if paginator is not null
				if (paginator != null) {
					String pageSql = sql + " limit " + (paginator.getPage() - 1) * paginator.getRows() + "," + paginator.getRows();
					metaObject.setValue("delegate.boundSql.sql", pageSql);
				}
			}
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		// determine if the intercepted object needs proxy, execute intercept function if true, return if no
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		// initialize interceptor config
		this.pageSqlId = properties.getProperty("pageSqlId");
	}

}
