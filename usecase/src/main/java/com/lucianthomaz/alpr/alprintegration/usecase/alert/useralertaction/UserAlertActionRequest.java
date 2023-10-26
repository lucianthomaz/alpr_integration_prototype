package com.lucianthomaz.alpr.alprintegration.usecase.alert.useralertaction;

import jakarta.validation.constraints.NotNull;

public record UserAlertActionRequest(@NotNull int alertId,
                                     @NotNull int userId,
                                     @NotNull Boolean accepted) {
}
