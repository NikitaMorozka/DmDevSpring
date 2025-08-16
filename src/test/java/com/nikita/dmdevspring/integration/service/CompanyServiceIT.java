package com.nikita.dmdevspring.integration.service;

import com.nikita.dmdevspring.dto.CompanyReadDto;
import com.nikita.dmdevspring.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



@RequiredArgsConstructor
@SpringBootTest
@Transactional
class CompanyServiceIT {

    private static Integer COMPANY_ID = 1;

    @Autowired
    private CompanyService companyService;


    @Test
    void findById(){
        Optional<CompanyReadDto> byId = companyService.findById(COMPANY_ID);

        assertTrue(byId.isPresent());

        CompanyReadDto companyReadDto = new CompanyReadDto(COMPANY_ID);

        assertEquals(byId, Optional.of(companyReadDto));

    }
}