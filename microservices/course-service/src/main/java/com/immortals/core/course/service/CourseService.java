package com.immortals.core.course.service;

import com.immortals.core.course.domain.Course;
import jakarta.validation.Valid;

public interface CourseService {
    Iterable<Course> viewCourses();

    Course viewCourseDetails(String title);

    Course viewCourseDetailsById(Long id);

    Course addCourse(@Valid Course course);

    void removeCourse(Long id);

    Course editCourseDetails(Long id, @Valid Course course);

}
