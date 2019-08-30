package ratingmaker.api.factory.entity;

import br.com.leonardoferreira.jbacon.JBacon;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;
import ratingmaker.api.domain.entity.Establishment;
import ratingmaker.api.repository.EstablishmentRepository;

@Component
public class EstablishmentFactory extends JBacon<Establishment> {

    private final EstablishmentRepository establishmentRepository;

    private final Faker faker;

    public EstablishmentFactory(final EstablishmentRepository establishmentRepository,
                                final Faker faker) {
        this.establishmentRepository = establishmentRepository;
        this.faker = faker;
    }

    @Override
    protected Establishment getDefault() {
        return Establishment.builder()
                .name(faker.gameOfThrones().house())
                .build();
    }

    @Override
    protected Establishment getEmpty() {
        return Establishment.builder()
                .build();
    }

    @Override
    protected void persist(Establishment establishment) {
        establishmentRepository.save(establishment);
    }
}
