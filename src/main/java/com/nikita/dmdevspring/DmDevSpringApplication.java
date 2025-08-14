package com.nikita.dmdevspring;
import com.nikita.dmdevspring.config.DataBaseProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DmDevSpringApplication {
    public static void main(String[] args) {
        var context = SpringApplication.run(DmDevSpringApplication.class, args);
        System.out.println(context.getBeanDefinitionCount());
        System.out.println(context.getBean("pool1"));
        System.out.println(context.getBean(DataBaseProperties.class));
    }
}