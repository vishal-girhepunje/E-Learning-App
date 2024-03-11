package com.GrowSkill.model;

import java.sql.Timestamp;
import java.util.UUID;

import com.GrowSkill.util.DateTimeUtil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(indexes = {@Index(columnList = "uid", name = "uid_index")})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String uid = UUID.randomUUID().toString();

    @OneToOne
    @JoinColumn(name = "student_user_id", nullable = false)
    private User user;

    private Timestamp createdAt = DateTimeUtil.getCurrentTimestamp();

    private Timestamp editedAt;
}
