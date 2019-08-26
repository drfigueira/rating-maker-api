package ratingmaker.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ratingmaker.api.domain.entity.ProductRating;

@Repository
public interface ProductRatingRepository extends JpaRepository<ProductRating, Long> {

}
