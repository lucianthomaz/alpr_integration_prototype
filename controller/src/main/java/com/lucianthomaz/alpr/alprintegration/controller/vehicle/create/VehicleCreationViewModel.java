package com.lucianthomaz.alpr.alprintegration.controller.vehicle.create;

import jakarta.validation.constraints.NotNull;

public record VehicleCreationViewModel(String license_plate,
                                       String model,
                                       String color) {
}
