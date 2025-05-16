package com.immortals.composite.course.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Review {

    private String id;
    private int courseId;
    private String author;
    private String content;
    private String email;

}
