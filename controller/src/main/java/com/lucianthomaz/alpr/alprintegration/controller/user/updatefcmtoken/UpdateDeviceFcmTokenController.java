package com.lucianthomaz.alpr.alprintegration.controller.user.updatefcmtoken;

import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UpdateDeviceFcmTokenController {
    UserRepository userRepository;
    @PutMapping(value = "/{id}/update-fcmtoken/{fcmToken}", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Update a user's fcmtoken")
    public ResponseEntity<String> updateLocation( @PathVariable int id,
                                                  @PathVariable String fcmToken) {
        userRepository.updateFcmToken(id, fcmToken);
        return ResponseEntity.ok("Fcm Token successfully updated!");
    }
}
