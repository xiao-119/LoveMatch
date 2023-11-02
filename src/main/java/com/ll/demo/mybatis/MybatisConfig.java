package com.ll.demo.mybatis;

import com.github.pagehelper.PageInterceptor;
import com.ll.demo.mybatis.intercept.FilterInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        sqlSessionFactoryBean.setPlugins(new Interceptor[]{new ExecutorPlugin()});
//        return sqlSessionFactoryBean.getObject();
//    }

    @Bean
    public Interceptor[] mybatisPlusInterceptors() {
        return new Interceptor[]{
//                new FilterInterceptor(),
                new PageInterceptor(),
        };
    }
}
