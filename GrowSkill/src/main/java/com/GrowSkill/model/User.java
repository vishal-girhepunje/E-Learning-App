package com.GrowSkill.model;

import java.sql.Timestamp;
import java.util.*;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(indexes = {@Index(columnList = "uid", name = "uid_index")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String uid = UUID.randomUUID().toString();

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    private String firstName;

    private String lastName;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 1 ")
    private boolean enabled;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 0 ")
    private boolean deleted;

    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    private Timestamp editedAt;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles")
    private Set<Role> roles = new HashSet<>();
}
