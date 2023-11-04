package com.lucianthomaz.alpr.alprintegration.controller.alert.getalertsbyuser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.controller.BasePresenter;
import com.lucianthomaz.alpr.alprintegration.controller.alert.shared.UserAlertViewModel;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.getalertsbyuser.GetAlertsByUserResponder;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.getalertsbyuser.GetAlertsByUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public class GetAlertPresenterByUser extends BasePresenter<GetAlertsByUserViewModel, GetAlertsByUserResponse> implements GetAlertsByUserResponder {
    private final ObjectMapper objectMapper;

    @Override
    public void onAccept(GetAlertsByUserResponse response) {
        GetAlertsByUserViewModel viewModel = new GetAlertsByUserViewModel(
                response.alerts().stream().map(
                        alert -> objectMapper.convertValue(alert, UserAlertViewModel.class)).toList());
        this.entity = ResponseEntity.ok(viewModel);
    }
}
