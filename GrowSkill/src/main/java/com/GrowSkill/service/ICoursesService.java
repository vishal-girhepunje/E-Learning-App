package com.GrowSkill.service;

import com.GrowSkill.api.request.CourseRequest;
import com.GrowSkill.api.response.CourseResponse;

import java.util.List;

public interface ICoursesService {
    public String createCourse(CourseRequest request);

    public CourseResponse getCourseByUid(String uid);

    public String deleteCourseByUid(String uid);

    public List<CourseResponse> findAllCourse();

    public String updateCourse(String uid,CourseRequest request);
}
