package ratingmaker.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ratingmaker.api.domain.entity.FeedbackRating;
import ratingmaker.api.domain.entity.ProductFeedback;
import ratingmaker.api.domain.request.ProductFeedbackRequest;
import ratingmaker.api.domain.response.ProductFeedbackResponse;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ProductFeedbackMapper {

    @Mappings({
            @Mapping(target = "product", source = "product.id"),
            @Mapping(target = "feedbackRating", source = "feedbackRatings")
    })
    ProductFeedbackResponse entityToResponse(ProductFeedback productFeedback);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
            @Mapping(target = "feedbackRatings", ignore = true),
            @Mapping(target = "product.id", source = "product")
    })
    ProductFeedback requestToEntity(ProductFeedbackRequest productFeedbackRequest);

    List<ProductFeedbackResponse> entitiesToResponses(List<ProductFeedback> productFeedbacks);

    List<ProductFeedback> requestsToEntities(List<ProductFeedbackRequest> productFeedbackRequests);

    default Integer averageProductRating(Set<FeedbackRating> productRatings) {
        Double average = productRatings.stream()
                .mapToInt(FeedbackRating::getRating)
                .average()
                .orElse(0);

        return average.intValue();
    }
}
