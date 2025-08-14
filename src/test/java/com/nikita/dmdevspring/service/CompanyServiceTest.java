package com.nikita.dmdevspring.service;

import com.nikita.dmdevspring.database.entity.Company;
import com.nikita.dmdevspring.database.repository.CompanyRepository;
import com.nikita.dmdevspring.dto.CompanyReadDto;
import com.nikita.dmdevspring.listener.entity.EntityEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {

    private static Integer COMPANY_ID = 1;

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private UserService userService;

    @Mock
    private ApplicationEventPublisher applicationEventPublisher;


    @InjectMocks
    private CompanyService companyService;


    @Test
    void findById_positiveTest(){
        when(companyRepository.findById(COMPANY_ID))
                .thenReturn(Optional.of(new Company(COMPANY_ID, null, Collections.EMPTY_MAP)));

        Optional<CompanyReadDto> byId = companyService.findById(COMPANY_ID);

        assertTrue(byId.isPresent());

        CompanyReadDto companyReadDto = new CompanyReadDto(COMPANY_ID);

        assertEquals(byId, Optional.of(companyReadDto));

        verify(applicationEventPublisher).publishEvent(any(EntityEvent.class));
    }

//      public Optional<CompanyReadDto> findById(Integer id){
//        return this.companyCrudRepository.findById(id)
//                .map(entity -> {
//                    applicationEventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
//                    return new CompanyReadDto(entity.id());
//                });
//    }
}