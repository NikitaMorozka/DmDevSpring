package com.nikita.dmdevspring.integration.database.repository;

import com.nikita.dmdevspring.database.entity.Company;
import com.nikita.dmdevspring.database.repository.CompanyRepository;
import com.nikita.dmdevspring.integration.annotation.IT;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@IT
class CompanyRepositoryTest {

    @Autowired private EntityManager entityManager;
    @Autowired private TransactionTemplate transactionTemplate;
    @Autowired private CompanyRepository companyRepository;


    @Test
    void checkFindByQueries(){
        companyRepository.findByName("google");
        companyRepository.findByNameContainingIgnoreCase("a");
    }

    @Test
    void delete(){
        var byId = companyRepository.findById(5);
        assertTrue(byId.isPresent());
        byId.ifPresent(companyRepository::delete);
        entityManager.flush();
        assertTrue(companyRepository.findById(5).isEmpty());
    }



    @Test
    void findById() {
        transactionTemplate.executeWithoutResult(tx -> {
            var company = entityManager.find(Company.class, 1);
            assertNotNull(company);
            Assertions.assertThat(company.getLocales()).hasSize(2);
        });
    }

    @Test
    void save() {
        var company = Company.builder()
                .name("Apple1")
                .locales(Map.of(
                        "ru", "Apple описание",
                        "en", "Apple description"
                ))
                .build();
        entityManager.persist(company);
        assertNotNull(company.getId());
    }
}