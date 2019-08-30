package ratingmaker.api.base;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import lombok.Data;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import ratingmaker.api.util.CleanDatabase;

import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;

@Data
public class BaseIntegrationTest {

    @Autowired
    private CleanDatabase cleanDatabase;

    @LocalServerPort
    private Integer port;

    @BeforeEach
    public void beforeEach() {
        RestAssured.port = port;
        cleanDatabase.clean();
    }

    protected ResponseSpecification notFoundSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(SC_NOT_FOUND)
                .expectBody("error", Matchers.is("Not Found"))
                .expectBody("message", Matchers.is("Resource Not Found"))
                .expectBody("status", Matchers.is(SC_NOT_FOUND))
                .build();
    }
}
