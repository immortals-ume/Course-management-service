package com.immortals.core.course.exception;

public class CourseAlreadyExitsException extends RuntimeException {
    public CourseAlreadyExitsException(String title) {
        super("A course with title " + title + " already exists.");
    }
}
