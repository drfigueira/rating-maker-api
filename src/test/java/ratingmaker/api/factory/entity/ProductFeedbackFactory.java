package ratingmaker.api.factory.entity;

import br.com.leonardoferreira.jbacon.JBacon;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;
import ratingmaker.api.domain.entity.ProductFeedback;
import ratingmaker.api.repository.ProductFeedbackRepository;

@Component
public class ProductFeedbackFactory extends JBacon<ProductFeedback> {

    private final ProductFeedbackRepository productFeedbackRepository;

    private final Faker faker;

    public ProductFeedbackFactory(final ProductFeedbackRepository productFeedbackRepository,
                                  final Faker faker) {
        this.productFeedbackRepository = productFeedbackRepository;
        this.faker = faker;
    }

    @Override
    protected ProductFeedback getDefault() {
        return ProductFeedback.builder()
                .feedback(faker.lorem().word())
                .build();
    }

    @Override
    protected ProductFeedback getEmpty() {
        return new ProductFeedback();
    }

    @Override
    protected void persist(ProductFeedback productFeedback) {
        productFeedbackRepository.save(productFeedback);
    }
}
