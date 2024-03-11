package com.GrowSkill.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(indexes = {@Index(columnList = "uid", name = "uid_index")})
public class StudentCourseAssignment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false,updatable = false)
	private String uid = UUID.randomUUID().toString();

	@ManyToOne(fetch = FetchType.LAZY)
	private Student student;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Courses course;

	private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

	private Timestamp editedAt;
	
	private LocalDate validFrom;

	private LocalDate validTo;

	@Column(columnDefinition = "TINYINT(1) DEFAULT 1 ")
	private boolean enabled;

	@Column(columnDefinition = "TINYINT(1) DEFAULT 0 ")
	private boolean deleted;

	@ManyToOne(fetch = FetchType.LAZY)
	private User createdByUser;
	@ManyToOne(fetch = FetchType.LAZY)
	private User editedByUser;
	
}
