package com.GrowSkill.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GrowSkill.model.Courses;

import java.util.List;
import java.util.Optional;

public interface ICoursesRepository extends JpaRepository<Courses, Long> {
    public List<Courses> findByEnabledTrueAndDeletedFalse();

    Optional<Courses> findByCourseIgnoreCase(String courseName);

    Optional<Courses> findByUidAndEnabledTrueAndDeletedFalse(String uid);

    Optional<Courses> findByUidAndDeletedFalse(String uid);

    boolean existsByCourseIgnoreCaseAndDeletedFalse(String courseName);
}
