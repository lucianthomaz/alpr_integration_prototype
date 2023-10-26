package com.lucianthomaz.alpr.alprintegration.controller.alert.useralertaction;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.controller.BasePresenter;
import com.lucianthomaz.alpr.alprintegration.controller.alert.shared.UserAlertViewModel;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.shared.UserAlertResponse;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.useralertaction.UserAlertActionResponder;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public class UserAlertActionPresenter extends BasePresenter<UserAlertViewModel, UserAlertResponse> implements UserAlertActionResponder {
    private final ObjectMapper objectMapper;

    @Override
    public void onAccept(UserAlertResponse response) {
        UserAlertViewModel viewModel = objectMapper.convertValue(response, UserAlertViewModel.class);
        this.entity = ResponseEntity.ok(viewModel);
    }
}
