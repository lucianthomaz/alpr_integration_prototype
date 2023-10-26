package com.lucianthomaz.alpr.alprintegration.usecase.alert.visualize;

import com.lucianthomaz.alpr.alprintegration.usecase.alert.shared.UserAlertResponse;

import java.util.List;

public record VisualizeAlertsResponse(List<UserAlertResponse> alerts) {
}
