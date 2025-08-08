package com.nikita.dmdevspring.service;

import com.nikita.dmdevspring.database.repository.CrudRepository;
import com.nikita.dmdevspring.database.repository.UserRepository;
import com.nikita.dmdevspring.database.entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;


}
