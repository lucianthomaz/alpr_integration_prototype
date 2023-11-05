package com.lucianthomaz.alpr.alprintegration.controller.alert.complete;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.complete.AlertCompletionRequest;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.complete.AlertCompletionUseCase;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/alert")
@AllArgsConstructor
public class AlertCompletionController {
    private final AlertCompletionUseCase useCase;
    private final ObjectMapper objectMapper;

    @PutMapping(value = "/finish", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Update alert status to completed")
    public ResponseEntity<AlertCompletionViewModel> createAlert(@RequestBody @Valid AlertCompletionRequest request) {
        AlertCompletionPresenter presenter = new AlertCompletionPresenter(objectMapper);
        useCase.execute(request, presenter);
        return presenter.responseEntity();
    }

    //Method to compare two distances using latitude and longitude and return true if within 5km

}