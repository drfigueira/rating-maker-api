package ratingmaker.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ratingmaker.api.domain.entity.Establishment;
import ratingmaker.api.domain.request.EstablishmentRequest;
import ratingmaker.api.domain.response.EstablishmentResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstablishmentMapper {

    EstablishmentResponse entityToResponse(Establishment establishment);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "products", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })
    Establishment requestToEntity(EstablishmentRequest establishmentRequest);

    List<EstablishmentResponse> entitiesToResponses(List<Establishment> establishments);

    List<Establishment> requestsToEntities(List<EstablishmentRequest> establishmentRequests);
}
