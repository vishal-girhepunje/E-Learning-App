package com.GrowSkill.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GrowSkill.model.InstructorCourseAssignment;

public interface IInstructorCourseAssignmentRepository extends JpaRepository<InstructorCourseAssignment, Long>{

}
