package com.lucianthomaz.alpr.alprintegration.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Alert {
    private int id;
    private int locationId;
    private String licensePlate;
    private int alertTypeId;
    private LocalDateTime dateTime;
    private String details;
    private String status;
    private String pictureUrl;
    private List<UserNotification> usersNotified;
}
