package com.immortal.core.review.exception;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(String id) {
        super("The review with id " + id + " was not found.");
    }
}
