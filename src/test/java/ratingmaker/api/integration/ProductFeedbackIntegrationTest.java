package ratingmaker.api.integration;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ratingmaker.api.base.BaseIntegrationTest;
import ratingmaker.api.domain.entity.Establishment;
import ratingmaker.api.domain.entity.Product;
import ratingmaker.api.domain.entity.ProductFeedback;
import ratingmaker.api.factory.entity.EstablishmentFactory;
import ratingmaker.api.factory.entity.FeedbackRatingFactory;
import ratingmaker.api.factory.entity.ProductFactory;
import ratingmaker.api.factory.entity.ProductFeedbackFactory;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductFeedbackIntegrationTest extends BaseIntegrationTest {

    private final ProductFeedbackFactory productFeedbackFactory;

    private final ProductFactory productFactory;

    private final EstablishmentFactory establishmentFactory;

    private final FeedbackRatingFactory feedbackRatingFactory;

    @Autowired
    public ProductFeedbackIntegrationTest(final ProductFeedbackFactory productFeedbackFactory,
                                          final ProductFactory productFactory,
                                          final EstablishmentFactory establishmentFactory,
                                          final FeedbackRatingFactory feedbackRatingFactory) {
        this.productFeedbackFactory = productFeedbackFactory;
        this.productFactory = productFactory;
        this.establishmentFactory = establishmentFactory;
        this.feedbackRatingFactory = feedbackRatingFactory;
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

    @Test
    void shouldReturnFeedbackRatingAverage3() {
        Establishment establishment = establishmentFactory.create();

        Product product = productFactory.create(empty -> {
            empty.setId(1L);
            empty.setEstablishment(establishment);
        });

        ProductFeedback productFeedback = productFeedbackFactory.create(empty -> {
            empty.setProduct(product);
        });

        feedbackRatingFactory.create(2, empty -> {
            empty.setProductFeedback(productFeedback);
            empty.setRating(3);
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
                .body("feedbackRating", Matchers.equalTo(3));
        //@formatter:on
    }

}
