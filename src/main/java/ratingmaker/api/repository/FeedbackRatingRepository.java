package ratingmaker.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ratingmaker.api.domain.entity.FeedbackRating;

@Repository
public interface FeedbackRatingRepository extends JpaRepository<FeedbackRating, Long> {
}
