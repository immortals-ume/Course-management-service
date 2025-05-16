package com.immortals.core.course.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String title) {
        super("The course with title " + title + " was not found.");
    }
}
