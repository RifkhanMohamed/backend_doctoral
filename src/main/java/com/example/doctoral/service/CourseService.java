package com.example.doctoral.service;

import com.example.doctoral.entity.Course;

import com.example.doctoral.repo.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepo courseRepo;

    public Course createNewCourse(Course course){
        return courseRepo.save(course);
    }

    public List<Course> getAllCourses(){
        return courseRepo.findAll();
    }
}
