package com.lucianthomaz.alpr.alprintegration.controller.alert.getalertsbyuser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.getalertsbyuser.GetAlertsByUserUseCase;
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
public class GetAlertsByUserController {
    private final GetAlertsByUserUseCase useCase;
    private final ObjectMapper objectMapper;

    @GetMapping(value = "/visualize-alerts/{userId}", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Creates a new alert")
    public ResponseEntity<GetAlertsByUserViewModel> getAlertsByUser(@PathVariable int userId) {
        GetAlertPresenterByUser presenter = new GetAlertPresenterByUser(objectMapper);
        useCase.execute(userId, presenter);
        return presenter.responseEntity();
    }
}
