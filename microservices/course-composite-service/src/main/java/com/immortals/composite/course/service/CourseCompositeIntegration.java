package com.immortals.composite.course.service;

import com.immortals.composite.course.entity.Course;
import com.immortals.composite.course.entity.CourseAggregate;
import com.immortals.composite.course.entity.Review;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
public class CourseCompositeIntegration implements CourseCompositeIntegrationService {
    private static final Logger log = LoggerFactory.getLogger(CourseCompositeIntegration.class);

    @Value("${app.course-service.uri}")
    private  String courseServiceUrl;

    @Value("${app.review-service.uri}")
    private  String reviewServiceUrl;

    private final WebClient webClient;

    public CourseCompositeIntegration(WebClient webClient) {
        this.webClient = webClient;
    }


    @Override
    public Mono<CourseAggregate> getCourseDetails(Long id, Jwt jwt) {

        log.debug("JWT ===> {}", jwt.getTokenValue());
        String courseUrl = courseServiceUrl + "/api/courses/" + id;
        String reviewUrl = reviewServiceUrl + "/api/reviews?course=" + id;
        log.debug("Course URL ===> {}", courseUrl);
        log.debug("Review URL ===> {}", reviewUrl);
        Mono<Course> courseMono = webClient.get()
                .uri(courseUrl)
                .header("Authorization", "Bearer " + jwt.getTokenValue())
                .retrieve()
                .bodyToMono(Course.class);

        Mono<List<Review>> reviewsMono = webClient.get()
                .uri(reviewUrl)
                .header("Authorization", "Bearer " + jwt.getTokenValue())
                .retrieve()
                .bodyToFlux(Review.class)
                .collectList();

        return Mono.zip(courseMono, reviewsMono)
                .map(tuple -> CourseAggregate
                        .builder()
                        .course(tuple.getT1())
                        .reviews(tuple.getT2())
                        .build());
    }
}
