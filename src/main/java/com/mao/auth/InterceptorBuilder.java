package com.mao.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册器
 * @author mao by 10:31 2019/8/30
 */
@Configuration
public class InterceptorBuilder implements WebMvcConfigurer {

    @Bean
    public SecurityInterceptor securityInterceptor(){
        return new SecurityInterceptor();
    }

    /**
     * 拦截器注册
     * @param registry 注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(securityInterceptor()).addPathPatterns("/api/**");
    }

    /**
     * 静态资源映射
     * 静态资源配置时：
     * 1.项目中的资源，资源路径前添加：classpath:
     * 2.项目外的资源，资源路径前添加：file:
     * @param registry 注册器
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/readme.html")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:C:\\images\\");
    }

}