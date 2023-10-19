package com.lucianthomaz.alpr.alprintegration.usecase.alert.sendtouser;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record SendToUserRequest (@NotNull int alertId,
                                 List<Integer> usersId,
                                 Boolean accepted){
}
