package com.duoc.LearningPlatform.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.duoc.LearningPlatform.model.Course;
import com.duoc.LearningPlatform.repository.CourseRepository;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner loadData(CourseRepository courseRepository){
        return args -> {
            courseRepository.save(new Course(null, "Java Básico", "Intro a Java", true));
            courseRepository.save(new Course(null, "Spring Boot", "Microservicios", true));
            courseRepository.save(new Course(null, "Python", "Fundamentos", false));
            courseRepository.save(new Course(null, "Angular", "Frontend", true));
            courseRepository.save(new Course(null, "docker", "Contenedores", true));
            courseRepository.save(new Course(null, "C++", "Programación avanzada", true));
            courseRepository.save(new Course(null, "algoritmos", "Lógica", true));
            courseRepository.save(new Course(null, "Base de Datos", "SQL", true));
        };
    }
}
