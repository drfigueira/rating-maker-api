package ratingmaker.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ratingmaker.api.domain.entity.ProductRating;
import ratingmaker.api.domain.request.ProductRatingRequest;
import ratingmaker.api.domain.response.ProductRatingResponse;

@Mapper(componentModel = "spring")
public interface ProductRatingMapper {

    ProductRatingResponse entityToResponse(ProductRating productRating);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
            @Mapping(target = "product", ignore = true)
    })
    ProductRating requestToEntity(ProductRatingRequest productRatingRequest);
}
