package com.lucianthomaz.alpr.alprintegration.controller.alerttype.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.usecase.alerttype.create.AlertTypeCreationRequest;
import com.lucianthomaz.alpr.alprintegration.usecase.alerttype.create.AlertTypeCreationUseCase;
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
@RequestMapping("/api/alert-type")
@AllArgsConstructor
public class AlertTypeCreationController {
    private final AlertTypeCreationUseCase useCase;
    private final ObjectMapper objectMapper;

    @PostMapping(value = "/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Creates a new alert type")
    public ResponseEntity<AlertTypeCreationViewModel> createAlertType(@RequestBody @Valid AlertTypeCreationRequest request) {
        AlertTypeCreationPresenter presenter = new AlertTypeCreationPresenter(objectMapper);
        useCase.execute(request, presenter);
        return presenter.responseEntity();
    }
}
