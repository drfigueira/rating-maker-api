package ratingmaker.api.factory.entity;

import br.com.leonardoferreira.jbacon.JBacon;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;
import ratingmaker.api.domain.entity.FeedbackRating;
import ratingmaker.api.repository.FeedbackRatingRepository;

@Component
public class FeedbackRatingFactory extends JBacon<FeedbackRating> {

    private final FeedbackRatingRepository feedbackRatingRepository;

    private final Faker faker;

    public FeedbackRatingFactory(final FeedbackRatingRepository feedbackRatingRepository,
                                 final Faker faker) {
        this.feedbackRatingRepository = feedbackRatingRepository;
        this.faker = faker;
    }

    @Override
    protected FeedbackRating getDefault() {
        return FeedbackRating.builder()
                .rating(faker.number().numberBetween(1, 5))
                .build();
    }

    @Override
    protected FeedbackRating getEmpty() {
        return new FeedbackRating();
    }

    @Override
    protected void persist(FeedbackRating feedbackRating) {
        feedbackRatingRepository.save(feedbackRating);
    }
}
