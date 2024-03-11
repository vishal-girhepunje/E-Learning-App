package com.GrowSkill.api.request;

import com.GrowSkill.model.CourseType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseRequest {

    @NotBlank(message = "CourseName Can't be Empty")
    private String courseName;

    @NotBlank(message = "Course Type Can't be Empty")
    private CourseType courseType;
}
