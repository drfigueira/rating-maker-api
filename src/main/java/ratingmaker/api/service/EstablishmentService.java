package ratingmaker.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ratingmaker.api.domain.entity.Establishment;
import ratingmaker.api.domain.request.EstablishmentRequest;
import ratingmaker.api.domain.response.EstablishmentResponse;
import ratingmaker.api.exception.ResourceNotFoundException;
import ratingmaker.api.mapper.EstablishmentMapper;
import ratingmaker.api.repository.EstablishmentRepository;

import java.util.List;

@Slf4j
@Service
public class EstablishmentService {

    private final EstablishmentRepository establishmentRepository;

    private final EstablishmentMapper establishmentMapper;

    public EstablishmentService(final EstablishmentRepository establishmentRepository,
                                final EstablishmentMapper establishmentMapper) {
        this.establishmentRepository = establishmentRepository;
        this.establishmentMapper = establishmentMapper;
    }

    public void save(final EstablishmentRequest establishmentRequest) {
        log.info("method=save, establishmentRequest={}", establishmentRequest);
        establishmentRepository.save(
                establishmentMapper.requestToEntity(establishmentRequest));
    }

    public List<EstablishmentResponse> findByNameIgnoreCaseContainingOrderByNameAsc(final String name) {
        log.info("method=findByNameIgnoreCaseContainingOrderByNameAsc, name={}", name);
        return establishmentMapper.entitiesToResponses(
                establishmentRepository.findByNameIgnoreCaseContainingOrderByNameAsc(name));
    }

    public List<EstablishmentResponse> findAll() {
        log.info("method=findAll");
        return establishmentMapper.entitiesToResponses(
                establishmentRepository.findAll());
    }

    public void update(final Long id,
                       final EstablishmentRequest establishmentRequest) {
        log.info("method=update, id={}, establishmentRequest={}", id, establishmentRequest);
        Establishment establishment = establishmentMapper.requestToEntity(establishmentRequest);
        establishment.setId(findIdIfExists(id));
        establishmentRepository.save(establishment);
    }

    public void delete(final Long id) {
        log.info("method=delete, id={}", id);
        establishmentRepository.deleteById(findIdIfExists(id));
    }

    public Long findIdIfExists(final Long id) {
        log.info("method=findIdIfExists, id={}", id);
        return establishmentRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new).getId();
    }
}
