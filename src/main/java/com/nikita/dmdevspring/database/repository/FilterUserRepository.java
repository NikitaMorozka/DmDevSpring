package com.nikita.dmdevspring.database.repository;

import com.nikita.dmdevspring.database.entity.User;
import com.nikita.dmdevspring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter userFilter);
}
