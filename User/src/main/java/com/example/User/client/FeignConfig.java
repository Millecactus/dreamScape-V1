package com.example.User.client;


import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configuration de Feign pour la communication avec le microservice "User"
@Configuration
public class FeignConfig {
    @Bean
    public DreamClient dreamClient() {
        return Feign.builder()
                .target(DreamClient.class, "http://localhost:8050/api/v1/dream"); // Remplacez "user-service-url" par l'URL du microservice User
    }
}
