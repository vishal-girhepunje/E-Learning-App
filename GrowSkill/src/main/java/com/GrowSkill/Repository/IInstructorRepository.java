package com.GrowSkill.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GrowSkill.model.Instructor;

public interface IInstructorRepository extends JpaRepository<Instructor, Long> {

}
