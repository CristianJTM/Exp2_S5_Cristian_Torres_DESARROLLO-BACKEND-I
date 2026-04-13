package com.duoc.LearningPlatform.repository;

import com.duoc.LearningPlatform.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
