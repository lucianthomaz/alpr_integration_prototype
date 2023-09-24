package com.lucianthomaz.alpr.alprintegration.usecase.usercreation;

import jakarta.validation.constraints.NotNull;

public record UserCreationRequest(@NotNull String name,
                                  @NotNull String email,
                                  @NotNull String username,
                                  @NotNull String password) {
}
