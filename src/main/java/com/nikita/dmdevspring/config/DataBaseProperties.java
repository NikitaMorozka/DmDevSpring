package com.nikita.dmdevspring.config;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "db")
public class DataBaseProperties {
    private String username;
    private String password;
    private String driver;
    private String url;
    private String hosts;
    private PoolProperties pool;
    private List<PoolProperties> pools;

    @Data
    @NoArgsConstructor
    public static class PoolProperties {
        private Integer size;
    }
}
