package com.immortals.core.course.repository;

import com.immortals.core.course.domain.Course;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course,Long> {

    Optional<Course> findByTitle(String title);
    Optional<Course> findById(Long id);
    boolean existsByTitle(String title);


    @Transactional
    void deleteById(Long id);

}
