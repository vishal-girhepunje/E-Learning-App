package com.GrowSkill.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GrowSkill.model.Student;

public interface IStudentRepository extends JpaRepository<Student, Long>{

}
