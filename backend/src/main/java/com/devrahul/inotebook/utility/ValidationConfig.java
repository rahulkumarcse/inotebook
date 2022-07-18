package com.devrahul.inotebook.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.servlet.http.PushBuilder;

@Configuration
public class ValidationConfig {
    @Bean
    public ValidatingMongoEventListener ValidatiONMongoEventListener(){
        return new ValidatingMongoEventListener(validation());
    }

    @Bean
    public LocalValidatorFactoryBean validation(){
        return new  LocalValidatorFactoryBean();
    }
}
