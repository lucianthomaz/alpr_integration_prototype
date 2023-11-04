package com.lucianthomaz.alpr.alprintegration.controller.alert.getalertsbyuser;

import com.lucianthomaz.alpr.alprintegration.controller.alert.shared.UserAlertViewModel;

import java.util.List;

public record GetAlertsByUserViewModel(List<UserAlertViewModel> visualizeAlerts) {
}
