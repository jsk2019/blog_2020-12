package com.ws.bighomeworkfirst.util;


import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CROSConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedMethods("GET","HEAD","POST","PUT","DELETE")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}
