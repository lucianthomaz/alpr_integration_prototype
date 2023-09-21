package com.lucianthomaz.alpr.alprintegration;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

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
