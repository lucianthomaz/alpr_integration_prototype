package com.lucianthomaz.alpr.alprintegration.usecase.alert.complete;

import java.time.LocalDateTime;

public record AlertCompletionResponse(int id,
                                      int locationId,
                                      String licensePlate,
                                      int alertTypeId,
                                      LocalDateTime creationDate,
                                      String details,
                                      String status,
                                      String pictureUrl) {
}
