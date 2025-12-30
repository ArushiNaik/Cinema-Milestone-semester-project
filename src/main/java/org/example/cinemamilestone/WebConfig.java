package org.example.cinemamilestone;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173", "https://cinema-frontend-ten-omega.vercel.app") // update
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowedHeaders("")
                .allowCredentials(true)
                .maxAge(3600);
    }
}