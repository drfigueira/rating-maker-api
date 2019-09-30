package ratingmaker.api.domain.response;

import lombok.Data;

@Data
public class ProductFeedbackResponse {

    private Long id;

    private Long product;

    private String feedback;

    private Integer feedbackRating;
}
