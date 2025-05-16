package com.immortal.core.review.domain;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
public class Review {

    @Id
    private String id;

    @Version
    private int version;
    private int courseId;
    private String author;
    private String content;
    @Indexed()
    private String email;

    private Review(ReviewBuilder builder) {
        this.id = builder.id;
        this.version = builder.version;
        this.courseId = builder.courseId;
        this.author = builder.author;
        this.content = builder.content;
        this.email = builder.email;
    }

    public String getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getEmail() {
        return email;
    }

    public static ReviewBuilder builder() {
        return new ReviewBuilder();
    }

    public static class ReviewBuilder {
        private String id;
        private int version;
        private int courseId;
        private String author;
        private String content;
        private String email;

        public ReviewBuilder id(String id) {
            this.id = id;
            return this;
        }

        public ReviewBuilder version(int version) {
            this.version = version;
            return this;
        }

        public ReviewBuilder courseId(int courseId) {
            this.courseId = courseId;
            return this;
        }

        public ReviewBuilder author(String author) {
            this.author = author;
            return this;
        }

        public ReviewBuilder content(String content) {
            this.content = content;
            return this;
        }

        public ReviewBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }
}