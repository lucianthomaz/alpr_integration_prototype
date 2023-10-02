package com.lucianthomaz.alpr.alprintegration.usecase.vehicle.create;

import jakarta.validation.constraints.NotNull;

public record VehicleCreationResponse(@NotNull String license_plate,
                                      @NotNull String model,
                                      @NotNull String color) {
}
