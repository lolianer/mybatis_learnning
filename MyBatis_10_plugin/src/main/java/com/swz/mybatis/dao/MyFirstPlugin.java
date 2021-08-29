package com.swz.mybatis.dao;


import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.Properties;

/**
 * @author shen_wzhong
 * @create 2021-08-29 10:06
 */
@Intercepts(
        {
                @Signature(type = StatementHandler.class,method = "parameterize",args = java.sql.Statement.class)
        }
)
public class MyFirstPlugin implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("执行了MyFirstPlugin------intercept------:" + invocation.getMethod());
        Object proceed = invocation.proceed();

        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        System.out.println();
        return Plugin.wrap(target, this);
    }


    @Override
    public void setProperties(Properties properties) {
        System.out.println("执行了properties-------:" + properties);

    }
}
