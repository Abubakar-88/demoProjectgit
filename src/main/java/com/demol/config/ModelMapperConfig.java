package com.demol.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
<<<<<<< HEAD


=======
>>>>>>> 2452534c2f35de445421f0209323bd5d1e59bea1
}
