package com.lucianthomaz.alpr.alprintegration.controller.alert.visualize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.visualize.VisualizeAlertsUseCase;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/alert")
@AllArgsConstructor
public class VisualizeAlertController {
    private final VisualizeAlertsUseCase useCase;
    private final ObjectMapper objectMapper;

    @GetMapping(value = "/visualize-alerts/{userId}", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Creates a new alert")
    public ResponseEntity<VisualizeAlertViewModel> visualizeAlert(@PathVariable int userId) {
        VisualizeAlertPresenter presenter = new VisualizeAlertPresenter(objectMapper);
        useCase.execute(userId, presenter);
        return presenter.responseEntity();
    }
}
