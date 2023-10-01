package com.lucianthomaz.alpr.alprintegration.controller.user.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.controller.BasePresenter;
import com.lucianthomaz.alpr.alprintegration.usecase.user.create.UserCreationResponder;
import com.lucianthomaz.alpr.alprintegration.usecase.user.create.UserCreationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public class UserCreationPresenter extends BasePresenter<UserCreationViewModel, UserCreationResponse> implements UserCreationResponder {
    private final ObjectMapper objectMapper;

    @Override
    public void onAccept(UserCreationResponse response) {
        UserCreationViewModel viewModel = objectMapper.convertValue(response, UserCreationViewModel.class);
        this.entity = ResponseEntity.status(HttpStatus.CREATED).body(viewModel);
    }
}
