package ratingmaker.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ratingmaker.api.domain.request.ProductRatingRequest;
import ratingmaker.api.service.ProductRatingService;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/products/ratings")
public class ProductRatingController {

    private final ProductRatingService productRatingService;

    public ProductRatingController(final ProductRatingService productRatingService) {
        this.productRatingService = productRatingService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void save(@Valid @RequestBody final ProductRatingRequest productRatingRequest) {
        productRatingService.save(productRatingRequest);
    }

}
