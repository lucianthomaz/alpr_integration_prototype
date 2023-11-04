package com.lucianthomaz.alpr.alprintegration.usecase.alert.create;

import com.lucianthomaz.alpr.alprintegration.domain.UserNotification;

import java.time.LocalDateTime;
import java.util.List;

public record AlertCreationResponse(int id,
                                    int locationId,
                                    String licensePlate,
                                    int alertTypeId,
                                    LocalDateTime creationDate,
                                    String details,
                                    String pictureUrl,
                                    List<UserNotification> usersNotified) {
}
