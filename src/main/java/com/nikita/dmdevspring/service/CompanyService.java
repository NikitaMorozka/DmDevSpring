package com.nikita.dmdevspring.service;

import com.nikita.dmdevspring.database.repository.CompanyRepository;
import com.nikita.dmdevspring.dto.CompanyReadDto;
import com.nikita.dmdevspring.listener.entity.AccessType;
import com.nikita.dmdevspring.listener.entity.EntityEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class CompanyService {

    private final UserService userService;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final CompanyRepository companyRepository;


    public Optional<CompanyReadDto> findById(Integer id){
        return this.companyRepository.findById(id)
                .map(entity -> {
                    applicationEventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDto(entity.getId());
                });
    }
}
