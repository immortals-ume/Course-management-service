package com.immortals.composite.course.controller;

import com.immortals.composite.course.entity.CourseAggregate;
import com.immortals.composite.course.service.CourseCompositeIntegrationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/course-aggregate")
public class CourseAggregateController {

    private static final Logger logger = LoggerFactory.getLogger(CourseAggregateController.class);


    private final CourseCompositeIntegrationService integration;

    public CourseAggregateController(CourseCompositeIntegrationService integration) {
        this.integration = integration;
    }

    @GetMapping("/{id}/with-details")
    public Mono<CourseAggregate> getCourses(@PathVariable Long id, @AuthenticationPrincipal Jwt jwt) {
        logger.info("Fetching course and review details for course id ===> {}", id);
        return integration.getCourseDetails(id, jwt);
    }
}
