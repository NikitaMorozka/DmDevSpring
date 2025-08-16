package com.nikita.dmdevspring.database.repository;

import com.nikita.dmdevspring.database.entity.User;
import com.nikita.dmdevspring.dto.UserFilter;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class FilterUserRepositoryImpl implements FilterUserRepository {

    private final EntityManager entityManager;


    @Override
    public List<User> findAllByFilter(UserFilter userFilter) {
        return List.of();
    }
}
