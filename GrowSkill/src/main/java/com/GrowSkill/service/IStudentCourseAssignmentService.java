package com.GrowSkill.service;

import com.GrowSkill.model.StudentCourseAssignment;

public interface IStudentCourseAssignmentService {
	StudentCourseAssignment assignStudentToCourse(Long studentId, Long courseId);
}
