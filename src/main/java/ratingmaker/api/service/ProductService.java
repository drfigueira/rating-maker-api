package ratingmaker.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ratingmaker.api.domain.entity.Product;
import ratingmaker.api.domain.request.ProductRequest;
import ratingmaker.api.domain.response.ProductResponse;
import ratingmaker.api.exception.ResourceNotFoundException;
import ratingmaker.api.mapper.ProductMapper;
import ratingmaker.api.repository.ProductRepository;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductService(final ProductRepository productRepository,
                          final ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public void save(final ProductRequest productRequest) {
        log.info("method=save, productRequest={}", productRequest);
        productRepository.save(
                productMapper.requestToEntity(productRequest));
    }

    public List<ProductResponse> findAll() {
        log.info("method=findAll");
        return productMapper.entitiesToResponses(
                productRepository.findAll());
    }

    public ProductResponse findById(final Long id) {
        log.info("method=findById, id={}", id);
        return productMapper.entityToResponse(
                productRepository.findById(id)
                    .orElseThrow(ResourceNotFoundException::new));
    }

    public void update(final Long id,
                       final ProductRequest productRequest) {
        log.info("method=update, id={}, productRequest={}", id, productRequest);
        Product product = productMapper.requestToEntity(productRequest);
        product.setId(findIdIfExists(id));
        productRepository.save(product);
    }

    public void delete(final Long id) {
        log.info("method=delete, id={}", id);
        productRepository.deleteById(findIdIfExists(id));
    }

    private Long findIdIfExists(final Long id) {
        log.info("method=findIdIfExists, id={}", id);
        return productRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new).getId();
    }
}
