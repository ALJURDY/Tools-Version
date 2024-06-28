package com.wired.toolsVersion.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200") // allow only from this origin
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // allow these methods
                        .allowedHeaders("*") // allow all headers
                        .allowCredentials(true) // allow credentials (cookies)
                        .maxAge(3600); // max age of the pre-flight response
            }
        };
    }
}
