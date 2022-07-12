package com.xy.springboot04.config;

import com.xy.springboot04.Interceptor.AllInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AllInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/index","/login")
                .excludePathPatterns("/css/**", "/fonts/**", "/images/**", "/js/**");
    }


}
