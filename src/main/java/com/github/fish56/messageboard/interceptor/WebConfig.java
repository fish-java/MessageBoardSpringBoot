package com.github.fish56.messageboard.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CORS())
                .addPathPatterns("/*")
                .order(3); // 2 will execute before 3
        registry.addInterceptor(new Verifier())
                .addPathPatterns("/*")
                .order(2);
    }
}
