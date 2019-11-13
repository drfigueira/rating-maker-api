package ratingmaker.api.domain.response;

import lombok.Data;

@Data
public class EstablishmentResponse {

    private Long id;

    private String name;

    private String location;

    private String image;
}
