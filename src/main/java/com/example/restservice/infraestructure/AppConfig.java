package com.example.restservice.infraestructure;

import com.example.restservice.infraestructure.repository.CatRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CatRepository catRepository() {
        return new CatRepository();
    }
}
