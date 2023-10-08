package com.lucianthomaz.alpr.alprintegration.controller.alert.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.controller.BasePresenter;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.create.AlertCreationResponder;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.create.AlertCreationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public class AlertCreationPresenter extends BasePresenter<AlertCreationViewModel, AlertCreationResponse> implements AlertCreationResponder {
    private final ObjectMapper objectMapper;

    @Override
    public void onAccept(AlertCreationResponse response) {
        AlertCreationViewModel viewModel = objectMapper.convertValue(response, AlertCreationViewModel.class);
        this.entity = ResponseEntity.status(HttpStatus.CREATED).body(viewModel);
    }
}
