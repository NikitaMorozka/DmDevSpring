package com.nikita.dmdevspring.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NamedEntityGraph(
        name = "User.component",
        attributeNodes = @NamedAttributeNode("company"))
@Entity
@ToString(exclude = "userChats")
@EqualsAndHashCode(of = "username")
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements BaseEntity<Long> {

    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String firstname;

    private String lastname;


    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<UserChat> userChats = new ArrayList<>();
}

//CREATE TABLE IF NOT EXISTS users
//(
//    id BIGSERIAL PRIMARY KEY ,
//    username VARCHAR(64) NOT NULL UNIQUE ,
//    birth_date DATE,
//    firstname VARCHAR(64),
//    lastname VARCHAR(64),
//    role VARCHAR(32),
//    company_id INT REFERENCES company (id)
//    );