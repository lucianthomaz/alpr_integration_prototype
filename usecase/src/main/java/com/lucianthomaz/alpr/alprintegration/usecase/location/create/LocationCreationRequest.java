package com.lucianthomaz.alpr.alprintegration.usecase.location.create;

import jakarta.validation.constraints.NotNull;

public record LocationCreationRequest (@NotNull String address,
                                       @NotNull String latitude,
                                       @NotNull String longitude,
                                       @NotNull String direction){
}
