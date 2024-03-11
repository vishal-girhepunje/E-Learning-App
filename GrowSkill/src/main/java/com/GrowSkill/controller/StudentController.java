package com.GrowSkill.controller;


import com.GrowSkill.api.request.UserCreationRequest;
import com.GrowSkill.model.Student;
import com.GrowSkill.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody UserCreationRequest request) {
        Student student = IStudentService.createStudent(request);
        return ResponseEntity.ok(student);
    }

    // Add endpoints for updating and deleting students
}