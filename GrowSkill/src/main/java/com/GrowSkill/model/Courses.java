package com.GrowSkill.model;

import java.sql.Timestamp;
import java.util.UUID;

import com.GrowSkill.util.DateTimeUtil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(indexes = {@Index(columnList = "uid", name = "uid_index")})
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String uid = UUID.randomUUID().toString();

    private String course;

    @Enumerated
    private CourseType courseType;

    private Timestamp createdAt = DateTimeUtil.getCurrentTimestamp();

    private Timestamp editedAt;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 1 ")
    private boolean enabled;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 0 ")
    private boolean deleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "createdById")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User createdUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "editedById")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User editedUser;
}
