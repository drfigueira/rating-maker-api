package ratingmaker.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ratingmaker.api.domain.response.ProductFeedbackResponse;
import ratingmaker.api.service.ProductFeedbackService;

import java.util.List;

@RestController
@RequestMapping("/products/{productId}/feedback")
public class ProductFeedbackController {

    private final ProductFeedbackService productFeedbackService;

    public ProductFeedbackController(final ProductFeedbackService productFeedbackService) {
        this.productFeedbackService = productFeedbackService;
    }

    @GetMapping
    public List<ProductFeedbackResponse> findByProductId(@PathVariable final Long productId) {
        return productFeedbackService.findByProductId(productId);
    }
}
