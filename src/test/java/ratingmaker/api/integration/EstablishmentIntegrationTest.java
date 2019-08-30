package ratingmaker.api.integration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ratingmaker.api.base.BaseIntegrationTest;
import ratingmaker.api.domain.entity.Establishment;
import ratingmaker.api.factory.entity.EstablishmentFactory;

import static io.restassured.http.ContentType.JSON;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EstablishmentIntegrationTest extends BaseIntegrationTest {

    private final EstablishmentFactory establishmentFactory;

    @Autowired
    public EstablishmentIntegrationTest(EstablishmentFactory establishmentFactory) {
        this.establishmentFactory = establishmentFactory;
    }

    @Test
    void shouldReturn5Establishments() {
        establishmentFactory.create(5);

        // @formatter:off
        RestAssured
                .given()
                    .log().all()
                .when()
                    .get("/establishments")
                .then()
                    .log().all()
                    .statusCode(200)
                    .body("$", Matchers.hasSize(5));
        // @formatter:on
    }

    @Test
    void shouldPersistEstablishment() {
        Establishment establishment = establishmentFactory.build();

        // @formatter:off
        RestAssured
                .given()
                    .log().all()
                    .contentType(JSON)
                    .body(establishment)
                .when()
                    .post("/establishments")
                .then()
                    .log().all()
                .statusCode(201);
        // @formatter:on

    }
}
