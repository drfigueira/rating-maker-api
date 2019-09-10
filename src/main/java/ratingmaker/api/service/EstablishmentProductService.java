package ratingmaker.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ratingmaker.api.domain.response.ProductResponse;
import ratingmaker.api.mapper.ProductMapper;
import ratingmaker.api.repository.ProductRepository;

import java.util.List;

@Slf4j
@Service
public class EstablishmentProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    private final EstablishmentService establishmentService;

    public EstablishmentProductService(final ProductRepository productRepository,
                                       final ProductMapper productMapper,
                                       final EstablishmentService establishmentService) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.establishmentService = establishmentService;
    }

    public List<ProductResponse> findByEstablishmentId(final Long establishmentId) {
        log.info("method=findByEstablishmentId, establishmentId={}", establishmentId);
        return productMapper.entitiesToResponses(
                productRepository.findByEstablishmentId(
                        establishmentService.findIdIfExists(establishmentId)));
    }
}
