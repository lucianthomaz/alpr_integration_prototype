package com.lucianthomaz.alpr.alprintegration.usecase.alert.create;

import jakarta.validation.constraints.NotNull;

public record AlertCreationRequest (@NotNull int locationId,
                                    @NotNull String licensePlate,
                                    @NotNull int alertTypeId,
                                    @NotNull String details,
                                    String pictureUrl){
}
