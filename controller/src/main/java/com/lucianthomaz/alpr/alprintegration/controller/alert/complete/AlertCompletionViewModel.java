package com.lucianthomaz.alpr.alprintegration.controller.alert.complete;

import java.time.LocalDateTime;

public record AlertCompletionViewModel(int id,
                                       int locationId,
                                       String licensePlate,
                                       int alertTypeId,
                                       LocalDateTime creationDate,
                                       String details,
                                       String status,
                                       String pictureUrl) {
}
