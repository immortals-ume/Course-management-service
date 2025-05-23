package com.immortal.core.review.repository;

import com.immortal.core.review.domain.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findByCourseIdAndEmail(Long courseId, String email);
    List<Review> findByEmail(String email);
    List<Review> findByCourseId(Long courseId);
    Optional<Review> findById(String id);
}
