package com.lucianthomaz.alpr.alprintegration.usecase.alerttype.create;

import jakarta.validation.constraints.NotNull;

public record AlertTypeCreationRequest(@NotNull String name,
                                       @NotNull String description) {
}
