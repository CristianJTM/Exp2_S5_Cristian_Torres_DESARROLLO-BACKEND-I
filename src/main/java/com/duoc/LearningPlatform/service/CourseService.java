package com.duoc.LearningPlatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.LearningPlatform.model.Course;
import com.duoc.LearningPlatform.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAvailableCourses(){
        List<Course> courses = courseRepository.findAll();

        return courses.stream()
                .filter(course -> course.isActive())
                .sorted((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()))
                .toList();
    }

    public Course getCourseById(Long id){
        return courseRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }
}
