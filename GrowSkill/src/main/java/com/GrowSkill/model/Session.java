package com.GrowSkill.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String uid = UUID.randomUUID().toString();

    @ManyToOne(fetch = FetchType.LAZY)
    private Courses course;

    private LocalDateTime fromTime;

    private LocalDateTime toTime;

    private String joinLink;

    private String recordedLink;

    private Timestamp createdAt = DateTimeUtil.getCurrentTimestamp();

    private Timestamp editedAt;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 1 ")
    private boolean enabled;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 0 ")
    private boolean deleted;

    @ManyToOne(fetch = FetchType.LAZY)
    private User createdByUser;

    @ManyToOne(fetch = FetchType.LAZY)
    private User editedByUser;


}
