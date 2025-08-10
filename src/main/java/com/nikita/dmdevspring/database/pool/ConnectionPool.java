package com.nikita.dmdevspring.database.pool;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//@Setter
@RequiredArgsConstructor
@Component("pool1")
@Slf4j
public class ConnectionPool {

    @Value("${db.username}")
    private final String username;
    @Value("${db.pool.size}")
    private final Integer poolSize;



    @PostConstruct
    private void init() {
        log.info("Init connection pool");
    }


    @PreDestroy
    private void destroy() {
        log.info("Clean connection pool");
    }
}
