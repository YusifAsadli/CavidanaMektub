package com.example.backend123blogg.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Configuartion {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}