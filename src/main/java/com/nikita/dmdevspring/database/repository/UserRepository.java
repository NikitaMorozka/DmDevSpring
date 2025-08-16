package com.nikita.dmdevspring.database.repository;

import com.nikita.dmdevspring.database.entity.Role;
import com.nikita.dmdevspring.database.entity.User;
import com.nikita.dmdevspring.database.pool.ConnectionPool;
import com.nikita.dmdevspring.dto.PersonalInfo;
import jakarta.persistence.LockModeType;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u " +
           "where u.firstname like %:firstname% " +
           "and u.lastname like %:lastname% ")
    List<User> findAllBy(String firstname, String lastname);

    @Query(value = "SELECT u.* FROM users u WHERE u.username = :username",
            nativeQuery = true)
    List<User> findAllByUsername(String username);


    @Modifying(clearAutomatically = true)
    @Query("update User u " +
    "set u.role = :role " +
    "where u.id in (:ids)")
    int updateRole(Role role, Long... ids);

    Optional<User> findTopByOrderByIdDesc();

    @Lock(LockModeType.PESSIMISTIC_READ)
    List<User> findTop3ByBirthDateBefore(LocalDate birthDate, Sort sort);

//    @EntityGraph("User.component")
    @EntityGraph(attributePaths = {"company", "company.locales"})
    @Query(value = "select u from User u",
    countQuery = "select count(distinct u.firstname) from User u")
    Slice<User> findAllBy(Pageable pageable);


    List<PersonalInfo> findAllByCompanyId(Integer companyId);
}
