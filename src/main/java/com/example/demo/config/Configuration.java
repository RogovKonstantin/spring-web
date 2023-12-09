package com.example.demo.config;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;



@org.springframework.context.annotation.Configuration
public class Configuration {


    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}
