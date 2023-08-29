package com.ll.demo.mybatis.intercept;

import com.ll.demo.annotation.UpdateTime;
import com.ll.demo.entity.User;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Intercepts;
import org.springframework.stereotype.Component;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 功能描述：拦截器  反射
 *帮助文档：https://blog.csdn.net/minghao0508/article/details/124420953
 * @author Songxianyang
 * @date 2022-08-12 21:50
 */
//@Component
@Intercepts({@Signature(type = Executor.class, method = "update",
        args = {MappedStatement.class, Object.class})})
public class AutoInsertTimeAndUser implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("AutoInsertTimeAndUser拦截了吗intercept");
        // 线程安全
//        AtomicReference<User> userAtomicReference = new AtomicReference<>();
//        userAtomicReference.set(new User("sxy"));

        // 获取一个MappedStatement
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        // 获取 SQL 命令 UNKNOWN, INSERT, UPDATE, DELETE, SELECT, FLUSH
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        // 获取参数
        Object parameter = invocation.getArgs()[1];

        // 获取私有成员变量
        Field[] declaredFields = parameter.getClass().getDeclaredFields();

        for (Field field : declaredFields) {
//            if (Objects.nonNull(field.getAnnotation(CreateTime.class))) {
//                // 插入
//                if (SqlCommandType.INSERT.equals(sqlCommandType)) {
//                    field.setAccessible(true);
//                    field.set(parameter, new Date());
//                }
//            }
//            if (Objects.nonNull(field.getAnnotation(CreateUser.class))) {
//                // 插入
//                if (SqlCommandType.INSERT.equals(sqlCommandType)) {
//                    field.setAccessible(true);
//                    field.set(parameter, userAtomicReference.get().getName());
//                }
//            }
            if (Objects.nonNull(field.getAnnotation(UpdateTime.class))) {
                // 修改
                if (SqlCommandType.UPDATE.equals(sqlCommandType)|| SqlCommandType.INSERT.equals(sqlCommandType)) {
                    field.setAccessible(true);
                    field.set(parameter, new Date());
                }
            }
//            if (Objects.nonNull(field.getAnnotation(UpdateUser.class))) {
//                // 修改
//                if (SqlCommandType.UPDATE.equals(sqlCommandType)||SqlCommandType.INSERT.equals(sqlCommandType)) {
//                    field.setAccessible(true);
//                    field.set(parameter, userAtomicReference.get().getName());
//                }
//            }
        }

        //获取方法参数
        Object[] args = invocation.getArgs();
        //获取方法名
        invocation.getMethod();
        //获取代理对象
        invocation.getTarget();
        return invocation.proceed();
    }

    /**
     * 生成MyBatis拦截器代理对象
     */
    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }
    /**
     * 设置插件属性（直接通过Spring的方式获取属性，所以这个方法一般也用不到）
     * 项目启动的时候数据就会被加载
     */
    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
    }
}
