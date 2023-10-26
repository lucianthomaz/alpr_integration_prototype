package com.lucianthomaz.alpr.alprintegration.controller.alert.useralertaction;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.controller.alert.shared.UserAlertViewModel;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.useralertaction.UserAlertActionRequest;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.useralertaction.UserAlertActionUseCase;
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
public class UserAlertActionController {
    private final UserAlertActionUseCase useCase;
    private final ObjectMapper objectMapper;

    @PutMapping(value = "/alert-action/",consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Acts (accept/reject) on an alert")
    public ResponseEntity<UserAlertViewModel> visualizeAlert(@Valid @RequestBody UserAlertActionRequest request) {
        UserAlertActionPresenter presenter = new UserAlertActionPresenter(objectMapper);
        useCase.execute(request, presenter);
        return presenter.responseEntity();
    }
}
