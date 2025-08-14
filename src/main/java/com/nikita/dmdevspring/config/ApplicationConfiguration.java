package com.nikita.dmdevspring.config;

import com.nikita.dmdevspring.database.pool.ConnectionPool;

import com.nikita.web.config.WebConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Import(WebConfiguration.class)
@Configuration
public class ApplicationConfiguration {



    @Bean("pool2")
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ConnectionPool pool2(@Value("${db.username}") String username) {
        return new ConnectionPool(username, 20);
    }

    @Bean()
    public ConnectionPool pool3() {
        return new ConnectionPool("test-pool", 25);
    }

}
