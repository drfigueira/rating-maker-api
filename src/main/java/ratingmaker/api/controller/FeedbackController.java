package ratingmaker.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ratingmaker.api.domain.request.ProductFeedbackRequest;
import ratingmaker.api.service.ProductFeedbackService;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final ProductFeedbackService productFeedbackService;

    public FeedbackController(final ProductFeedbackService productFeedbackService) {
        this.productFeedbackService = productFeedbackService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void save(@Valid @RequestBody final ProductFeedbackRequest productFeedbackRequest) {
        productFeedbackService.save(productFeedbackRequest);
    }
}
