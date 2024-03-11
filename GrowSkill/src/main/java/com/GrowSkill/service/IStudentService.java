package com.GrowSkill.service;

import com.GrowSkill.model.Student;

public interface IStudentService {
	public Student createStudent(Student student);

	public Student getStudentById(Long studentId);

	public void deleteStudentById(Long studentId);
}
