package com.immortals.core.course.service;

import com.immortals.core.course.domain.Course;
import com.immortals.core.course.exception.CourseAlreadyExitsException;
import com.immortals.core.course.exception.CourseNotFoundException;
import com.immortals.core.course.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImplementation implements CourseService {

    private final Logger logger = LoggerFactory.getLogger(CourseServiceImplementation.class);

    private final CourseRepository courseRepository;

    public CourseServiceImplementation(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Iterable<Course> viewCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course viewCourseDetails(String title) {
        return courseRepository.findByTitle(title)
                .orElseThrow(() -> new CourseNotFoundException(title));
    }

    @Override
    public Course viewCourseDetailsById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(String.valueOf(id)));
    }

    @Override
    public Course addCourse(Course course) {

        logger.info("Checking if course '{}' already exists...", course.getTitle());

        if (courseRepository.existsByTitle(course.getTitle())) {
            logger.warn("Course '{}' already exists! Throwing exception.", course.getTitle());
            throw new CourseAlreadyExitsException(course.getTitle());
        }

        Course savedCourse = courseRepository.save(course);
        logger.info("Course '{}' saved successfully with ID: {}", savedCourse.getTitle(), savedCourse.getId());

        return savedCourse;
    }

    @Override
    public void removeCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course editCourseDetails(Long id, Course course) {
        return courseRepository.findById(id)
                .map(existingCourse -> {
                    existingCourse.setTitle(course.getTitle());
                    existingCourse.setAuthor(course.getAuthor());
                    existingCourse.setPrice(course.getPrice());
                    existingCourse.setPublisher(course.getPublisher());
                    return courseRepository.save(existingCourse);
                }).orElseGet(() -> addCourse(course));

    }
}
