package com.nikita.dmdevspring.config;

import com.nikita.dmdevspring.database.pool.ConnectionPool;
import com.nikita.dmdevspring.database.repository.CrudRepository;
import com.nikita.dmdevspring.database.repository.UserRepository;
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

    @Bean
    @Profile("prod")
    public UserRepository userRepository(ConnectionPool pool2){
        return new UserRepository(pool2);
    }

    @Bean
    public UserRepository userRepository2(){
        var connectionPool1 = pool3();
        var connectionPool2 = pool3();
        var connectionPoo3 = pool3();
        return new UserRepository(pool3());
    }
}
