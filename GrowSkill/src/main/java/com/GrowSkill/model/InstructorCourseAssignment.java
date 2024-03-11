package com.GrowSkill.model;

import java.sql.Timestamp;
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
public class InstructorCourseAssignment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false,updatable = false)
	private String uid = UUID.randomUUID().toString();
	@ManyToOne(fetch = FetchType.LAZY)
	private Instructor instructor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Courses course;

	private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

	private Timestamp editedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User createdByUser;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User editedByUser;
}
