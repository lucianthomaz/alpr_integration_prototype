package com.lucianthomaz.alpr.alprintegration.controller.alert.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.create.AlertCreationRequest;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.create.AlertCreationUseCase;
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
@RequestMapping("/api/alert")
@AllArgsConstructor
public class AlertCreationController {
    private final AlertCreationUseCase useCase;
    private final ObjectMapper objectMapper;

    @PostMapping(value = "/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Creates a new alert")
    public ResponseEntity<AlertCreationViewModel> createAlert(@RequestBody @Valid AlertCreationRequest request) {
        AlertCreationPresenter presenter = new AlertCreationPresenter(objectMapper);
        useCase.execute(request, presenter);
        return presenter.responseEntity();
    }
}
