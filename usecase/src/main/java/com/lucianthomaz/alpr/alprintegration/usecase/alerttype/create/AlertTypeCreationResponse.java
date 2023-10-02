package com.lucianthomaz.alpr.alprintegration.usecase.alerttype.create;

import jakarta.validation.constraints.NotNull;

public record AlertTypeCreationResponse(@NotNull int id,
                                        @NotNull String name,
                                        @NotNull String description) {
}
