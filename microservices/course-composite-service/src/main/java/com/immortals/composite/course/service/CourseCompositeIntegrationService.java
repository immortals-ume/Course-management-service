package com.immortals.composite.course.service;

import com.immortals.composite.course.entity.CourseAggregate;
import org.springframework.security.oauth2.jwt.Jwt;
import reactor.core.publisher.Mono;

public interface CourseCompositeIntegrationService {
    Mono<CourseAggregate> getCourseDetails(Long id, Jwt jwt);
}
