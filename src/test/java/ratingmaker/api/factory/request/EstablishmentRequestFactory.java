package ratingmaker.api.factory.request;

import br.com.leonardoferreira.jbacon.JBacon;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;
import ratingmaker.api.domain.request.EstablishmentRequest;

@Component
public class EstablishmentRequestFactory extends JBacon<EstablishmentRequest> {

    private final Faker faker;

    public EstablishmentRequestFactory(final Faker faker) {
        this.faker = faker;
    }

    @Override
    protected EstablishmentRequest getDefault() {
        return EstablishmentRequest.builder()
                .name(faker.gameOfThrones().house())
                .build();
    }

    @Override
    protected EstablishmentRequest getEmpty() {
        return EstablishmentRequest.builder()
                .build();
    }

    @Override
    protected void persist(EstablishmentRequest establishmentRequest) {
        throw new UnsupportedOperationException();
    }
}
