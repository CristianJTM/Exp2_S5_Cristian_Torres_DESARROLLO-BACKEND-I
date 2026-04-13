package com.duoc.LearningPlatform.repository;

import com.duoc.LearningPlatform.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// Se utiliza un repositorio en memoria con ArrayList para simular persistencia,
// cumpliendo con el requisito de usar estructuras de almacenamiento temporal.
// Esto reemplaza el uso de JpaRepository en esta implementación.


@Repository
public class CourseRepository {

    private List<Course> courses = new ArrayList<>();
    private Long currentId = 1L;


    public Course save(Course course) {
        if (course.getId() == null) {
            course.setId(currentId++);
        }
        courses.add(course);
        return course;
    }

    public List<Course> findAll() {
        return courses;
    }

    public Optional<Course> findById(Long id) {
        return courses.stream()
                .filter(c -> Objects.equals(c.getId(), id))
                .findFirst();
    }

    public void deleteById(Long id) {
        courses.removeIf(c -> Objects.equals(c.getId(), id));
    }
}
