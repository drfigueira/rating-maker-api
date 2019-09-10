package ratingmaker.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ratingmaker.api.domain.entity.FeedbackRating;
import ratingmaker.api.domain.request.FeedbackRatingRequest;
import ratingmaker.api.domain.response.FeedbackRatingResponse;

@Mapper(componentModel = "spring")
public interface FeedbackRatingMapper {

   FeedbackRatingResponse entityToResponse(FeedbackRating feedbackRating);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
            @Mapping(target = "productFeedback", ignore = true)
    })
    FeedbackRating requestToEntity(FeedbackRatingRequest feedbackRatingRequest);
}
