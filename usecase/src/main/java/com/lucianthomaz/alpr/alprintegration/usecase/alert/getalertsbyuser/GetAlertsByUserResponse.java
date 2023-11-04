package com.lucianthomaz.alpr.alprintegration.usecase.alert.getalertsbyuser;

import com.lucianthomaz.alpr.alprintegration.usecase.alert.shared.UserAlertResponse;

import java.util.List;

public record GetAlertsByUserResponse(List<UserAlertResponse> alerts) {
}
