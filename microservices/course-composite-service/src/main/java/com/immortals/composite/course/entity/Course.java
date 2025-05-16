package com.immortals.composite.course.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {
    private Long id;
    private String title;
    private String author;
    private Double price;
    private String publisher;
}
