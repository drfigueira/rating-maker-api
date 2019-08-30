package ratingmaker.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ratingmaker.api.domain.request.ProductFeedbackRequest;
import ratingmaker.api.domain.response.ProductFeedbackResponse;
import ratingmaker.api.mapper.ProductFeedbackMapper;
import ratingmaker.api.repository.ProductFeedbackRepository;

import java.util.List;

@Slf4j
@Service
public class ProductFeedbackService {

    private final ProductFeedbackRepository productFeedbackRepository;

    private final ProductFeedbackMapper productFeedbackMapper;

    public ProductFeedbackService(final ProductFeedbackRepository productFeedbackRepository,
                                  final ProductFeedbackMapper productFeedbackMapper) {
        this.productFeedbackRepository = productFeedbackRepository;
        this.productFeedbackMapper = productFeedbackMapper;
    }

    public List<ProductFeedbackResponse> findByProductId(final Long productId) {
        log.info("method=findByProductId, productId={}", productId);
        return productFeedbackMapper.entitiesToResponses(
                productFeedbackRepository.findByProductId(productId));
    }

    public void save(final ProductFeedbackRequest productFeedbackRequest) {
        log.info("method=save, productFeedbackRequest={}", productFeedbackRequest);
        productFeedbackRepository.save(
                productFeedbackMapper.requestToEntity(productFeedbackRequest));
    }
}
