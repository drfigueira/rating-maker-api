package ratingmaker.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ratingmaker.api.domain.request.ProductRequest;
import ratingmaker.api.domain.response.ProductResponse;
import ratingmaker.api.service.ProductService;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable final Long id) {
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void save(@Valid @RequestBody final ProductRequest productRequest) {
        productService.save(productRequest);
    }
}
