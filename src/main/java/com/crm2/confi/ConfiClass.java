package com.crm2.confi;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiClass {
    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
}
