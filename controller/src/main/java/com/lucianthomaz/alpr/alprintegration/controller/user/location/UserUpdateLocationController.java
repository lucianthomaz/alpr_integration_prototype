package com.lucianthomaz.alpr.alprintegration.controller.user.location;

import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserUpdateLocationController {
    UserRepository userRepository;

    @PutMapping(value = "/update-location", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Update a user's location")
    public ResponseEntity<String> updateLocation(@RequestBody @Valid LocationRequest request) {
        System.out.println("Latitude: " + request.latitude() + " Longitude: " + request.longitude());
        String message = "\"status\": \"OK\"";
        userRepository.updateLocation(request.username(), request.latitude(), request.longitude());
        return ResponseEntity.ok(message);
    }
}
