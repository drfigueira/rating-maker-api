package ratingmaker.api.domain.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EstablishmentRequest {

    @NotBlank
    private String name;
}
