package ratingmaker.api.integration;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ratingmaker.api.base.BaseIntegrationTest;
import ratingmaker.api.domain.request.EstablishmentRequest;
import ratingmaker.api.factory.request.EstablishmentRequestFactory;

import static io.restassured.http.ContentType.JSON;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EstablishmentRequestIntegrationTest extends BaseIntegrationTest {

    private final EstablishmentRequestFactory establishmentRequestFactory;

    @Autowired
    public EstablishmentRequestIntegrationTest(final EstablishmentRequestFactory establishmentRequestFactory) {
        this.establishmentRequestFactory = establishmentRequestFactory;
    }

    @Test
    void shouldPersistsEstablishmentRequest() {
        EstablishmentRequest establishmentRequest = establishmentRequestFactory.build();

        // @formatter:off
        RestAssured
                .given()
                    .log().all()
                    .contentType(JSON)
                    .body(establishmentRequest)
                .when()
                    .post("/establishments")
                .then()
                    .log().all()
                    .statusCode(201);
        // @formatter:on

    }
}
