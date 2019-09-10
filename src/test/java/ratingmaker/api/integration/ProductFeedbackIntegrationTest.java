package ratingmaker.api.integration;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ratingmaker.api.base.BaseIntegrationTest;
import ratingmaker.api.domain.entity.Product;
import ratingmaker.api.factory.entity.EstablishmentFactory;
import ratingmaker.api.factory.entity.ProductFactory;
import ratingmaker.api.factory.entity.ProductFeedbackFactory;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductFeedbackIntegrationTest extends BaseIntegrationTest {

    private final ProductFeedbackFactory productFeedbackFactory;

    private final ProductFactory productFactory;

    private final EstablishmentFactory establishmentFactory;

    @Autowired
    public ProductFeedbackIntegrationTest(final ProductFeedbackFactory productFeedbackFactory,
                                          final ProductFactory productFactory,
                                          final EstablishmentFactory establishmentFactory) {
        this.productFeedbackFactory = productFeedbackFactory;
        this.productFactory = productFactory;
        this.establishmentFactory = establishmentFactory;
    }

    @Test
    void shouldReturn5ProductFeedback() {
        Product product = productFactory.create(empty -> {
            empty.setId(1L);
            empty.setEstablishment(establishmentFactory.create());
        });

        productFeedbackFactory.create(5, empty -> {
            empty.setProduct(product);
        });

        // @formatter:off
        RestAssured
                .given()
                    .log().all()
                .when()
                    .get("/products/1/feedback")
                .then()
                    .log().all()
                    .statusCode(200)
                    .body("$", Matchers.hasSize(5));
        //@formatter:on
    }

}
