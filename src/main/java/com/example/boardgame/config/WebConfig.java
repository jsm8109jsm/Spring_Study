package com.example.boardgame.config;

import com.example.boardgame.intercepter.SessionIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionIntercepter())
                .order(2)
                .addPathPatterns("/select", "/newBoard");
//                .excludePathPatterns("/css/**", "/*.ico", "/error","/login");

    }
};