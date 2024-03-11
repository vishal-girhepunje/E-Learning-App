package com.GrowSkill.service.impl;

import com.GrowSkill.Repository.ICoursesRepository;
import com.GrowSkill.api.request.CourseRequest;
import com.GrowSkill.api.response.CourseResponse;
import com.GrowSkill.exception.BadRequestException;
import com.GrowSkill.model.Courses;
import com.GrowSkill.service.ICoursesService;
import com.GrowSkill.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements ICoursesService {

    @Autowired
    private ICoursesRepository  coursesRepository;

    @Override
    public String createCourse(CourseRequest request) {
        Courses courses = coursesRepository.findByCourseIgnoreCase(request.getCourseName()).orElseThrow(() -> new BadRequestException("Course Name Already Exists"));
        Courses newCourse = new Courses();
        newCourse.setCourse(request.getCourseName());
        newCourse.setCourseType(request.getCourseType());
        coursesRepository.save(newCourse);
        return "Course Created Successfully";
    }

    @Override
    public CourseResponse getCourseByUid(String uid) {
        Courses courses = coursesRepository.findByUidAndDeletedFalse(uid).orElseThrow(()-> new BadRequestException("Course Doesn't exist"));
        return new CourseResponse(courses.getUid(),courses.getCourse(),courses.getCourseType().toString());
    }

    @Override
    public String deleteCourseByUid(String uid) {
        Courses courses = coursesRepository.findByUidAndDeletedFalse(uid).orElseThrow(() -> new BadRequestException("Course Doesn't exist"));
        courses.setDeleted(true);
        courses.setEditedAt(DateTimeUtil.getCurrentTimestamp());
        return "Course Deleted Successfully";
    }

    @Override
    public List<CourseResponse> findAllCourse() {
        List<Courses> courses = coursesRepository.findByEnabledTrueAndDeletedFalse();
        Function<Courses,CourseResponse> function = e -> new CourseResponse(e.getUid(),e.getCourse(),e.getCourseType().toString());
        return courses.stream().map(function).collect(Collectors.toList());
    }

    @Override
    public String updateCourse(String uid,CourseRequest courseRequest) {
        Courses courses = coursesRepository.findByUidAndDeletedFalse(uid).orElseThrow(() -> new BadRequestException("Course Doesn't exist"));
        boolean doesCourseNameAlreadyExists = coursesRepository.existsByCourseIgnoreCaseAndDeletedFalse(courseRequest.getCourseName());
        if(doesCourseNameAlreadyExists) throw new BadRequestException("Course Name Already Exist Choose Another Name");
        courses.setCourse(courseRequest.getCourseName());
        courses.setEditedAt(DateTimeUtil.getCurrentTimestamp());
        coursesRepository.save(courses);
        return "Course Updated Successfully";
    }

}
