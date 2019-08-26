package ratingmaker.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ratingmaker.api.domain.entity.ProductFeedback;

@Repository
public interface ProductFeedbackRepository extends JpaRepository<ProductFeedback, Long> {

}
