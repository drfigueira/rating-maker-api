package ratingmaker.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ratingmaker.api.domain.response.ProductResponse;
import ratingmaker.api.service.EstablishmentProductService;
import ratingmaker.api.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/establishments/{establishmentId}/products")
public class EstablishmentProductController {

    private final EstablishmentProductService establishmentProductService;

    private final ProductService productService;

    public EstablishmentProductController(final EstablishmentProductService establishmentProductService,
                                          final ProductService productService) {
        this.establishmentProductService = establishmentProductService;
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponse> findByEstablishmentId(@PathVariable final Long establishmentId) {
        return establishmentProductService.findByEstablishmentId(establishmentId);
    }
}
