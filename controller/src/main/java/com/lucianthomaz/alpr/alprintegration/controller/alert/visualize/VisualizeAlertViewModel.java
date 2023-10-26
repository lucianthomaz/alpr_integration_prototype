package com.lucianthomaz.alpr.alprintegration.controller.alert.visualize;

import com.lucianthomaz.alpr.alprintegration.controller.alert.shared.UserAlertViewModel;

import java.util.List;

public record VisualizeAlertViewModel(List<UserAlertViewModel> visualizeAlerts) {
}
