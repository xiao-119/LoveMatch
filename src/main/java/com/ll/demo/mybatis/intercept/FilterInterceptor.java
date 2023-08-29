package com.ll.demo.mybatis.intercept;

import cn.hutool.core.util.ReflectUtil;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.util.Properties;

/**
 * MappedStatement: 它包含了 SQL 语句、输入参数和输出结果的映射配置。
 * Object: 这是传递给 SQL 语句的参数对象。
 * RowBounds: 用于分页查询的边界。
 * ResultHandler: 用于处理查询结果。
 * CacheKey: 用于 MyBatis 的缓存机制，表示一个特定查询的缓存键。
 * BoundSql: 表示绑定的 SQL 语句，包括 SQL 本身和与之关联的参数。
 */
//@Component
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class FilterInterceptor implements Interceptor {
    private Properties properties = new Properties();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("拦截FilterInterceptor");
//        Object[] args = invocation.getArgs();
//        MappedStatement ms = (MappedStatement) args[0];
//        BoundSql boundSql = ms.getBoundSql(args[1]);
//        String originalSql = boundSql.getSql();

        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String originalSql = boundSql.getSql();
        // 检查SQL是否是查询user表的
        if (originalSql != null && originalSql.toLowerCase().contains("from user")) {
            String modifiedSql = originalSql;
            String[] limits = originalSql.toLowerCase().split("limit");
            if (limits.length > 1) {
                modifiedSql = limits[0] + " WHERE role = 'admin' limit" + limits[1];
            }


            if (!modifiedSql.toLowerCase().contains("where")) {
                modifiedSql = originalSql + " WHERE role = 'admin'";
            }
            // 修改SQL以添加过滤条件
            ReflectUtil.setFieldValue(boundSql, "sql", modifiedSql);
        }
        // 插件逻辑
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        System.out.println("拦截了吗plugin");
        return Interceptor.super.plugin(target);
//        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        // 设置属性
        System.out.println("拦截了吗setProperties");
        this.properties = properties;
    }
}
