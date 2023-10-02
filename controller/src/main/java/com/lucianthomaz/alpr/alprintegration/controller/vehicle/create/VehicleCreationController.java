package com.lucianthomaz.alpr.alprintegration.controller.vehicle.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.usecase.vehicle.create.VehicleCreationRequest;
import com.lucianthomaz.alpr.alprintegration.usecase.vehicle.create.VehicleCreationUseCase;
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
@RequestMapping("/api/vehicle")
@AllArgsConstructor
public class VehicleCreationController {
    private final VehicleCreationUseCase useCase;
    private final ObjectMapper objectMapper;

    @PostMapping(value = "/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Creates a new vehicle")
    public ResponseEntity<VehicleCreationViewModel> createVehicle(@RequestBody @Valid VehicleCreationRequest request) {
        VehicleCreationPresenter presenter = new VehicleCreationPresenter(objectMapper);
        useCase.execute(request, presenter);
        return presenter.responseEntity();
    }
}
