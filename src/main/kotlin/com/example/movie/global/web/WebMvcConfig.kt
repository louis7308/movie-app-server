package com.example.movie.global.web

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfig : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
            .allowedOrigins(
                "http://localhost:3000",
            )
            .allowCredentials(true)
            .allowedHeaders("Authorization", "Content-Type", "Refresh-Token")
            .exposedHeaders(HttpHeaders.CONTENT_DISPOSITION)
    }
}