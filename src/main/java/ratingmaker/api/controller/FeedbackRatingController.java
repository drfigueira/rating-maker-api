package ratingmaker.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ratingmaker.api.domain.request.FeedbackRatingRequest;
import ratingmaker.api.service.FeedbackRatingService;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/feedback/ratings")
public class FeedbackRatingController {

    private final FeedbackRatingService feedbackRatingService;

    public FeedbackRatingController(final FeedbackRatingService feedbackRatingService) {
        this.feedbackRatingService = feedbackRatingService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void save(@Valid @RequestBody final FeedbackRatingRequest feedbackRatingRequest) {
        feedbackRatingService.save(feedbackRatingRequest);
    }
}
