package com.lucianthomaz.alpr.alprintegration.controller.user.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.controller.BasePresenter;
import com.lucianthomaz.alpr.alprintegration.usecase.usercreation.UserCreationResponder;
import com.lucianthomaz.alpr.alprintegration.usecase.usercreation.UserCreationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public class UserCreationPresenter extends BasePresenter<UserCreationViewModel, UserCreationResponse> implements UserCreationResponder {
    private final ObjectMapper objectMapper;

    @Override
    public void onAccept(UserCreationResponse response) {
        UserCreationViewModel viewModel = objectMapper.convertValue(response, UserCreationViewModel.class);
        this.entity = ResponseEntity.ok(viewModel);
    }
}
