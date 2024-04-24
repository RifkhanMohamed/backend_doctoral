package com.example.doctoral.controller;

import com.example.doctoral.entity.Course;
import com.example.doctoral.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/course")
@RequiredArgsConstructor
@CrossOrigin("*")
@Validated
public class CourseController {
    private final CourseService courseService;

    @PostMapping(path = "/create")
    public Course createNewCourse(@RequestBody Course course){
        return courseService.createNewCourse(course);
    }

    @GetMapping(path = "/get")
    public List<Course> getAllCourse(){
        return courseService.getAllCourses();
    }
}
