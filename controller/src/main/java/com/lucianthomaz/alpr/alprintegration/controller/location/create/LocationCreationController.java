package com.lucianthomaz.alpr.alprintegration.controller.location.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.usecase.location.create.LocationCreationRequest;
import com.lucianthomaz.alpr.alprintegration.usecase.location.create.LocationCreationUseCase;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/location")
@AllArgsConstructor
public class LocationCreationController {
    private final LocationCreationUseCase useCase;
    private final ObjectMapper objectMapper;

    @PostMapping(value = "/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Creates a new location")
    public ResponseEntity<LocationCreationViewModel> createLocation(@RequestBody @Valid LocationCreationRequest request) {
        LocationCreationPresenter presenter = new LocationCreationPresenter(objectMapper);
        useCase.execute(request, presenter);
        return presenter.responseEntity();
    }
}
