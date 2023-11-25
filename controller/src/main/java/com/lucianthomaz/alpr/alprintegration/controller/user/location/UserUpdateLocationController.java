package com.lucianthomaz.alpr.alprintegration.controller.user.location;

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

    @PutMapping(value = "/update-location", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Update a user's location")
    public ResponseEntity<String> updateLocation(@RequestBody @Valid LocationRequest request) {
        System.out.println("Latitude: " + request.latitude() + " Longitude: " + request.longitude());
        String message = "\"status\": \"OK\"";
        NotificationService notificationService = new NotificationService();
        notificationService.sendPushNotification(
                "cX3Yf5nBQMyF8aIhnCl-Hl:APA91bGTUO7v-7WI_VCvdR2N7nsqOpWHzlrUrse8TnbpMvZlSiee1oiNqt-7dhHojRAPx40PZSxpVEnc-EpEfYtA_M9EB1rNe4pWNAyMtR-Hax8h_asc7jAsxXtSQwcGg19fOIIHXP2O",
                "TestT Title",
                "Test Body");
        return ResponseEntity.ok(message);
    }
}
