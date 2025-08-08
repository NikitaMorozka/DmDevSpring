package com.nikita.dmdevspring.config;

import com.nikita.dmdevspring.config.condition.JpaCondition;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Conditional(JpaCondition.class)
@Configuration
public class JpaConfiguration {
//
//    @Bean
//    @ConfigurationProperties(prefix = "db" )
//    public DataBaseProperties dataBaseProperties(){
//        return new DataBaseProperties();
//    }

    @PostConstruct
    void init(){
        System.out.println("jpa config is enabled");
    }
}
