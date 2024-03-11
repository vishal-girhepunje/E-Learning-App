package com.GrowSkill.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GrowSkill.model.StudentCourseAssignment;

public interface IStudentCourseAssignmentRepository extends JpaRepository<StudentCourseAssignment, Long>{

}
