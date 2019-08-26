package ratingmaker.api.domain.response;

import lombok.Data;

@Data
public class ProductResponse {

    private Long id;

    private String name;

    private Integer productRating;

    private Long establishment;
}
