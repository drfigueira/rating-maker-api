package ratingmaker.api.factory.request;

import br.com.leonardoferreira.jbacon.JBacon;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;
import ratingmaker.api.domain.request.EstablishmentRequest;
import ratingmaker.api.repository.EstablishmentRepository;

@Component
public class EstablishmentRequestFactory extends JBacon<EstablishmentRequest> {

    private final EstablishmentRepository establishmentRepository;

    private final Faker faker;

    public EstablishmentRequestFactory(final EstablishmentRepository establishmentRepository,
                                       final Faker faker) {
        this.establishmentRepository = establishmentRepository;
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
        return new EstablishmentRequest();
    }

    @Override
    protected void persist(EstablishmentRequest establishmentRequest) {
        throw new UnsupportedOperationException();
    }
}
