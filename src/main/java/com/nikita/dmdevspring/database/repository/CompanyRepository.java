package com.nikita.dmdevspring.database.repository;

import com.nikita.dmdevspring.database.bpp.Auditing;
import com.nikita.dmdevspring.database.bpp.Transaction;
import com.nikita.dmdevspring.database.pool.ConnectionPool;
import com.nikita.dmdevspring.database.entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Transaction
@Auditing
@Repository
@Scope("prototype")
@RequiredArgsConstructor
public class CompanyRepository implements CrudRepository<Integer, Company> {

    private final ConnectionPool pool1;
    @Value("${db.pool.size}")
    private final Integer poolSize;

    @PostConstruct
    private void init() {
        System.out.println("init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method...");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete method...");
    }
}