package ratingmaker.api.factory.entity;

import br.com.leonardoferreira.jbacon.JBacon;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;
import ratingmaker.api.domain.entity.ProductRating;
import ratingmaker.api.repository.ProductRatingRepository;

@Component
public class ProductRatingFactory extends JBacon<ProductRating> {

    private final ProductRatingRepository productRatingRepository;

    private final Faker faker;

    public ProductRatingFactory(final ProductRatingRepository productRatingRepository,
                                final Faker faker) {
        this.productRatingRepository = productRatingRepository;
        this.faker = faker;
    }

    @Override
    protected ProductRating getDefault() {
        return ProductRating.builder()
                .rating(faker.number().numberBetween(1, 5))
                .build();
    }

    @Override
    protected ProductRating getEmpty() {
        return new ProductRating();
    }

    @Override
    protected void persist(ProductRating productRating) {
        productRatingRepository.save(productRating);
    }
}
