package com.nikita.dmdevspring.integration.database.repository;

import com.nikita.dmdevspring.database.entity.Role;
import com.nikita.dmdevspring.database.entity.User;
import com.nikita.dmdevspring.database.repository.UserRepository;
import com.nikita.dmdevspring.integration.annotation.IT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@IT
class UserRepositoryTest {
    @Autowired private UserRepository userRepository;


    @Test
    void checkQueries() {
        var users = userRepository.findAllBy("a", "ov");
        assertThat(users).hasSize(3);
        System.out.println(users);

    }

    @Test
    void checkUpdate() {
        var ivan = userRepository.getById(1L);
        assertSame(Role.ADMIN,ivan.getRole());

        var resultCount = userRepository.updateRole(Role.USER, 1L, 5L);
        assertEquals(2, resultCount);

        var theSameIvan = userRepository.getById(1L);
        assertSame(Role.USER, theSameIvan.getRole());
    }
}