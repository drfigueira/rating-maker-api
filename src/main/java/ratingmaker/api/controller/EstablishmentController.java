package ratingmaker.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ratingmaker.api.domain.request.EstablishmentRequest;
import ratingmaker.api.domain.response.EstablishmentResponse;
import ratingmaker.api.service.EstablishmentService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/establishments")
public class EstablishmentController {

    private final EstablishmentService establishmentService;

    public EstablishmentController(final EstablishmentService establishmentService) {
        this.establishmentService = establishmentService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void save(@Valid @RequestBody final EstablishmentRequest establishmentRequest) {
        establishmentService.save(establishmentRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable final Long id,
                       @Valid @RequestBody final EstablishmentRequest establishmentRequest) {
        establishmentService.update(id, establishmentRequest);
    }

    @GetMapping
    public List<EstablishmentResponse> findAll() {
        return establishmentService.findAll();
    }

    @GetMapping("/{name}")
    public List<EstablishmentResponse> findByNameIgnoreCaseContainingOrderByNameAsc(@PathVariable final String name) {
        return establishmentService.findByNameIgnoreCaseContainingOrderByNameAsc(name);
    }
}
