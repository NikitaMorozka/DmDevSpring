package com.nikita.dmdevspring.service;

import com.nikita.dmdevspring.database.repository.CrudRepository;
import com.nikita.dmdevspring.dto.CompanyReadDto;
import com.nikita.dmdevspring.database.entity.Company;
import com.nikita.dmdevspring.listener.entity.AccessType;
import com.nikita.dmdevspring.listener.entity.EntityEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final UserService userService;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final CrudRepository<Integer, Company> companyCrudRepository;


    public Optional<CompanyReadDto> findById(Integer id){
        return this.companyCrudRepository.findById(id)
                .map(entity -> {
                    applicationEventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDto(entity.id());
                });
    }
}
