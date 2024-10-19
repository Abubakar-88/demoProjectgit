package com.demol.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

<<<<<<< HEAD
    @Bean
    public ModelMapper  modelMapperBeanCreate(){
        return new ModelMapper();
    }

=======

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
<<<<<<< HEAD


=======
>>>>>>> 2452534c2f35de445421f0209323bd5d1e59bea1
>>>>>>> eec26067228f30ba420b3fa341603c4befb8e9a4
}
