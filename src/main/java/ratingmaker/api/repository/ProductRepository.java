package ratingmaker.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ratingmaker.api.domain.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
