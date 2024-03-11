package com.GrowSkill.service;

import com.GrowSkill.model.Instructor;

public interface IInstructorService {
	public Instructor createInstructor(Instructor instructor);

	public Instructor getInstructorById(Long instructorId);

	void deleteInstructorById(Long instructorId);

}
