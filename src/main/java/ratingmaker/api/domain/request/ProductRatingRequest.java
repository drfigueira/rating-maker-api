package ratingmaker.api.domain.request;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class ProductRatingRequest {

    @NotNull
    @Positive
    private Long product;

    @Min(1)
    @Max(5)
    @NotNull
    private Integer rating;
}
