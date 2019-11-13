package ratingmaker.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ratingmaker.api.domain.request.ProductRatingRequest;
import ratingmaker.api.mapper.ProductRatingMapper;
import ratingmaker.api.repository.ProductRatingRepository;

@Slf4j
@Service
public class ProductRatingService {

    private final ProductRatingRepository productRatingRepository;

    private final ProductRatingMapper productRatingMapper;

    public ProductRatingService(final ProductRatingRepository productRatingRepository,
                                final ProductRatingMapper productRatingMapper) {
        this.productRatingRepository = productRatingRepository;
        this.productRatingMapper = productRatingMapper;
    }

    public void save(final ProductRatingRequest productRatingRequest) {
        log.info("method=save, productRatingRequest={}", productRatingRequest);
        productRatingRepository.save(
                productRatingMapper.requestToEntity(productRatingRequest));
    }

}
