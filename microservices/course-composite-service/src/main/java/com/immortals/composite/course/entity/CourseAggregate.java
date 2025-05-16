package com.immortals.composite.course.entity;

import java.util.List;
import java.util.Objects;

public class CourseAggregate {
    private Course course;
    private List<Review> reviews;

    private CourseAggregate(Builder builder) {
        this.course = builder.course;
        this.reviews = builder.reviews;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Course course;
        private List<Review> reviews;

        public Builder course(Course course) {
            this.course = course;
            return this;
        }

        public Builder reviews(List<Review> reviews) {
            this.reviews = reviews;
            return this;
        }

        public CourseAggregate build() {
            return new CourseAggregate(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseAggregate that = (CourseAggregate) o;
        return Objects.equals(course, that.course) &&
                Objects.equals(reviews, that.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, reviews);
    }

    @Override
    public String toString() {
        return "CourseAggregate{" +
                "course=" + course +
                ", reviews=" + reviews +
                '}';
    }
}
