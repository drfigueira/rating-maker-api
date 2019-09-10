package ratingmaker.api.factory.entity;

import br.com.leonardoferreira.jbacon.JBacon;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;
import ratingmaker.api.domain.entity.Product;
import ratingmaker.api.repository.ProductRepository;

@Component
public class ProductFactory extends JBacon<Product> {

    private final ProductRepository productRepository;

    private final Faker faker;

    public ProductFactory(final ProductRepository productRepository,
                          final Faker faker) {
        this.productRepository = productRepository;
        this.faker = faker;
    }

    @Override
    protected Product getDefault() {
        return Product.builder()
                .name(faker.gameOfThrones().character())
                .build();
    }

    @Override
    protected Product getEmpty() {
        return new Product();
    }

    @Override
    protected void persist(Product product) {
        productRepository.save(product);
    }
}
