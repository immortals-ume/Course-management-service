package com.immortal.core.review.service;

import com.immortal.core.review.domain.Review;
import com.immortal.core.review.dto.ReviewDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface ReviewService {
    List<Review> getReviewsByCourseId(Long courseId);

    Review getReviewId(String id);

    List<Review> getAllReviews();

    Review addReview(@Valid ReviewDTO review);

    List<Review> getReviewsByCourseIdAndEmail(Long courseId, String email);

    void deleteReview(String id);
}
