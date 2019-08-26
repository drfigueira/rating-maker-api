package ratingmaker.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ratingmaker.api.domain.entity.Product;
import ratingmaker.api.domain.entity.ProductRating;
import ratingmaker.api.domain.request.ProductRequest;
import ratingmaker.api.domain.response.ProductResponse;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings({
            @Mapping(target = "establishment", source = "establishment.id"),
            @Mapping(target = "productRating", source = "productRatings")
    })
    ProductResponse entityToResponse(Product establishment);

    @Mappings({
            @Mapping(target = "establishment.id", source = "establishment"),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "productRatings", ignore = true),
            @Mapping(target = "productFeedbacks", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })
    Product requestToEntity(ProductRequest establishmentRequest);

    List<ProductResponse> entitiesToResponses(List<Product> establishments);

    List<Product> requestsToEntities(List<ProductRequest> establishmentRequests);

    default Integer averageProductRating(Set<ProductRating> productRatings) {
        Double average = productRatings.stream()
                .mapToInt(ProductRating::getRating)
                .average()
                .orElse(0);

        return average.intValue();
    }
}
