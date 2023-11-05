package com.lucianthomaz.alpr.alprintegration.usecase.alert.complete;

import jakarta.validation.constraints.NotNull;

public record AlertCompletionRequest(@NotNull Integer alertId,
                                     @NotNull Integer userId) {
}
