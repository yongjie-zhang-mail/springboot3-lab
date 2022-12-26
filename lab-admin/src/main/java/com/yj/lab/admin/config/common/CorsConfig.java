package com.yj.lab.admin.config.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Zhang Yongjie
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    /**
     * x 跨域支持
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 允许跨域访问的路径
        registry.addMapping("/**")
                // 允许跨域访问的源 的模式
                // .allowedOrigins("*")
                .allowedOriginPatterns("*")
                // 允许的头部设置
                .allowedHeaders("*")
                // 允许发送cookie
                .allowCredentials(true)
                // 允许请求的方法
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS", "HEAD")
                // 预检间隔时间
                .maxAge(3600 * 24);
    }
}
