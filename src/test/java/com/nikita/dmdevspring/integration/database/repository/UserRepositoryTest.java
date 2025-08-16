package com.nikita.dmdevspring.integration.database.repository;

import com.nikita.dmdevspring.database.entity.Role;
import com.nikita.dmdevspring.database.entity.User;
import com.nikita.dmdevspring.database.repository.UserRepository;
import com.nikita.dmdevspring.dto.PersonalInfo;
import com.nikita.dmdevspring.integration.annotation.IT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;


    @Test
    void check(){
        List<PersonalInfo> allByCompanyId = userRepository.findAllByCompanyId(1);
        allByCompanyId.forEach(personalInfo -> System.out.println(personalInfo));
    }

    @Test
    void checkPageable() {
        var pa = PageRequest.of(1, 2, Sort.by("id"));
        var slice = userRepository.findAllBy(pa);
        slice.forEach(user -> System.out.println(user.getCompany().getName()));

        while(slice.hasNext()){
            slice = userRepository.findAllBy(slice.nextPageable());
            slice.forEach(user -> System.out.println(user.getCompany().getName()));
        }
//        assertThat(slice).hasSize(2);
    }

    @Test
    void checkSort() {
        Sort.by("id").and(Sort.by("firstName"));

        var sort = Sort.sort(User.class);
        sort.by(User::getFirstname).and(sort.by(User::getLastname));
    }

    @Test
    void checkFirstTop() {
        Sort orders = Sort.by("id").and(Sort.by("firstname"));
        List<User> allUsers = userRepository.findTop3ByBirthDateBefore(LocalDate.now(), orders);
        assertThat(allUsers).hasSize(3);

        var topByOrderByIdDesc = userRepository.findTopByOrderByIdDesc();
        assertTrue(topByOrderByIdDesc.isPresent());
        topByOrderByIdDesc.ifPresent(user -> assertEquals(5L, user.getId()));
    }

    @Test
    void checkQueries() {
        var users = userRepository.findAllBy("a", "ov");
        assertThat(users).hasSize(3);
        System.out.println(users);

    }

    @Test
    void checkUpdate() {
        var ivan = userRepository.getById(1L);
        assertSame(Role.ADMIN, ivan.getRole());

        var resultCount = userRepository.updateRole(Role.USER, 1L, 5L);
        assertEquals(2, resultCount);

        var theSameIvan = userRepository.getById(1L);
        assertSame(Role.USER, theSameIvan.getRole());
    }
}