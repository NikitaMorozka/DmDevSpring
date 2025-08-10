package com.nikita.dmdevspring.integration.service;

import com.nikita.dmdevspring.database.entity.Company;
import com.nikita.dmdevspring.database.repository.CrudRepository;
import com.nikita.dmdevspring.dto.CompanyReadDto;
import com.nikita.dmdevspring.listener.entity.EntityEvent;
import com.nikita.dmdevspring.service.CompanyService;
import com.nikita.dmdevspring.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = ApplicationRunner.class)
class CompanyServiceIT {

    @Test
    void findById(){

    }
}