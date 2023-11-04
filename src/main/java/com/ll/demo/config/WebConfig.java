package com.ll.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc // 配置自定义的Web MVC并覆盖默认配置 自行配置Web MVC的各个方面，包括静态资源、视图解析器、拦截器、消息转换器等等。这意味着您需要更多的自定义和配置工作。
public class WebConfig implements WebMvcConfigurer {

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        // 设置默认主页路径为 "/index.html"
//        registry.addViewController("/index").setViewName("index");
//    }
//
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        //此处还可继续增加目录。。。。
//    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.addAllowedOrigin("*"); // 允许来自特定域的跨域请求
        corsConfig.addAllowedMethod("*"); // 允许所有HTTP方法
        corsConfig.addAllowedHeader("*"); // 允许所有HTTP头

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsFilter(source);
    }
}
