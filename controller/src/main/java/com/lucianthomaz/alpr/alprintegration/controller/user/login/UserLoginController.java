package com.lucianthomaz.alpr.alprintegration.controller.user.login;

import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserLoginController {
    UserRepository userRepository;
    @PostMapping(value = "/login/")
    @Operation(summary = "User's login")
    public Boolean updateLocation(@RequestParam String username,
                                  @RequestParam String password) {
        return userRepository.authenticate(username, password);
    }
}
