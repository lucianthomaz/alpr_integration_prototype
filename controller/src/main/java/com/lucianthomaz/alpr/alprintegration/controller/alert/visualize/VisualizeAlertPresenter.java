package com.lucianthomaz.alpr.alprintegration.controller.alert.visualize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.controller.BasePresenter;
import com.lucianthomaz.alpr.alprintegration.controller.alert.shared.UserAlertViewModel;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.visualize.VisualizeAlertsResponder;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.visualize.VisualizeAlertsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public class VisualizeAlertPresenter extends BasePresenter<VisualizeAlertViewModel, VisualizeAlertsResponse> implements VisualizeAlertsResponder {
    private final ObjectMapper objectMapper;

    @Override
    public void onAccept(VisualizeAlertsResponse response) {
        VisualizeAlertViewModel viewModel = new VisualizeAlertViewModel(
                response.alerts().stream().map(
                        alert -> objectMapper.convertValue(alert, UserAlertViewModel.class)).toList());
        this.entity = ResponseEntity.ok(viewModel);
    }
}
