package com.lucianthomaz.alpr.alprintegration.controller.user.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.usecase.usercreation.UserCreationRequest;
import com.lucianthomaz.alpr.alprintegration.usecase.usercreation.UserCreationUseCase;
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
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserCreationController {
    private final UserCreationUseCase userCreationUseCase;
    private final ObjectMapper objectMapper;

    @PostMapping(value = "/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Creates a new user")
    public ResponseEntity<UserCreationViewModel> createUser(@RequestBody @Valid UserCreationRequest request) {
        UserCreationPresenter presenter = new UserCreationPresenter(objectMapper);
        userCreationUseCase.execute(request, presenter);
        return presenter.responseEntity();
    }
}
