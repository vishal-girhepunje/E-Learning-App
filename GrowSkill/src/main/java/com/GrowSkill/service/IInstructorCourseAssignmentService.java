package com.GrowSkill.service;

import com.GrowSkill.model.InstructorCourseAssignment;

public interface IInstructorCourseAssignmentService {
	InstructorCourseAssignment assignInstructorToCourse(Long instructorId, Long courseId);
}
