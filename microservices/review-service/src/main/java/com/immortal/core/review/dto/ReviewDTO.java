package com.immortal.core.review.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class ReviewDTO {

    @NotNull(message = "The course id must be defined.")
    private int courseId;
    @NotBlank(message = "Author is required")
    @Size(min = 4, max = 40, message = "Author must be between 4 and 40 characters")
    private String author;
    @NotBlank(message = "Content is required")
    @Size(min = 5, max = 500, message = "Content must be between 50 and 500 characters")
    private String content;
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    public @NotNull(message = "The course id must be defined.") int getCourseId() {
        return courseId;
    }

    public void setCourseId(@NotNull(message = "The course id must be defined.") int courseId) {
        this.courseId = courseId;
    }

    public @NotBlank(message = "Author is required") @Size(min = 4, max = 40, message = "Author must be between 4 and 40 characters") String getAuthor() {
        return author;
    }

    public void setAuthor(@NotBlank(message = "Author is required") @Size(min = 4, max = 40, message = "Author must be between 4 and 40 characters") String author) {
        this.author = author;
    }

    public @NotBlank(message = "Content is required") @Size(min = 5, max = 500, message = "Content must be between 50 and 500 characters") String getContent() {
        return content;
    }

    public void setContent(@NotBlank(message = "Content is required") @Size(min = 5, max = 500, message = "Content must be between 50 and 500 characters") String content) {
        this.content = content;
    }

    public @NotBlank(message = "Email is required") @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is required") @Email(message = "Email should be valid") String email) {
        this.email = email;
    }
}
