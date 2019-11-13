package ratingmaker.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ratingmaker.api.domain.request.FeedbackRatingRequest;
import ratingmaker.api.mapper.FeedbackRatingMapper;
import ratingmaker.api.repository.FeedbackRatingRepository;

@Slf4j
@Service
public class FeedbackRatingService {

    private final FeedbackRatingRepository feedbackRatingRepository;

    private final FeedbackRatingMapper feedbackRatingMapper;

    public FeedbackRatingService(final FeedbackRatingRepository feedbackRatingRepository,
                                 final FeedbackRatingMapper feedbackRatingMapper) {
        this.feedbackRatingRepository = feedbackRatingRepository;
        this.feedbackRatingMapper = feedbackRatingMapper;
    }

    public void save(final FeedbackRatingRequest feedbackRatingRequest) {
        log.info("method=save, feedbackRatingRequest={}", feedbackRatingRequest);
        feedbackRatingRepository.save(
                feedbackRatingMapper.requestToEntity(feedbackRatingRequest));
    }

}
