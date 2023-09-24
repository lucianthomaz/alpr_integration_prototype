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
    private Location location;
    private Vehicle vehicle;
    private AlertType alertType;
    private LocalDateTime dateTime;
    private String details;
    private StatusEnum status;
    private String pictureUrl;
    private List<User> usersNotified;
}
