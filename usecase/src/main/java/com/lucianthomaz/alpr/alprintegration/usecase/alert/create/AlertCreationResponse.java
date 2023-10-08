package com.lucianthomaz.alpr.alprintegration.usecase.alert.create;

import java.time.LocalDateTime;

public record AlertCreationResponse(int id,
                                    int locationId,
                                    String licensePlate,
                                    int alertTypeId,
                                    LocalDateTime dateTime,
                                    String details,
                                    String pictureUrl) {
}
