package com.duoc.LearningPlatform.config;

import com.duoc.LearningPlatform.model.Course;
import com.duoc.LearningPlatform.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner loadData(CourseRepository courseRepository){
        return args -> {
            courseRepository.save(new Course(null, "Java Básico", "Intro a Java", true));
            courseRepository.save(new Course(null, "Spring Boot", "Microservicios", true));
            courseRepository.save(new Course(null, "Python", "Fundamentos", false));
        };
    }
}
