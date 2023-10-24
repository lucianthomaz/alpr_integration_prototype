package com.lucianthomaz.alpr.alprintegration.usecase.alert.visualize;

import com.lucianthomaz.alpr.alprintegration.domain.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserAlertResponse {
    private int id;
    private int locationId;
    private String licensePlate;
    private int alertTypeId;
    private LocalDateTime dateTime;
    private String details;
    private StatusEnum status;
    private String pictureUrl;
    private Boolean accepted;
}
