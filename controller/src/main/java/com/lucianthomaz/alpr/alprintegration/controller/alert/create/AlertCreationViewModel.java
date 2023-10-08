package com.lucianthomaz.alpr.alprintegration.controller.alert.create;

import java.time.LocalDateTime;

public record AlertCreationViewModel(int id,
                                     int locationId,
                                     String licensePlate,
                                     int alertTypeId,
                                     LocalDateTime dateTime,
                                     String details,
                                     String pictureUrl) {
}
