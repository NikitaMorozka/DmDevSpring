package com.nikita.dmdevspring.database.repository;

import com.nikita.dmdevspring.database.pool.ConnectionPool;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {
@Qualifier("pool1")
    private final ConnectionPool connectionPool;

}
