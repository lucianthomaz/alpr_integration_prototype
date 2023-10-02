package com.lucianthomaz.alpr.alprintegration.controller.alerttype.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.controller.BasePresenter;
import com.lucianthomaz.alpr.alprintegration.usecase.alerttype.create.AlertTypeCreationResponder;
import com.lucianthomaz.alpr.alprintegration.usecase.alerttype.create.AlertTypeCreationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public class AlertTypeCreationPresenter extends BasePresenter<AlertTypeCreationViewModel, AlertTypeCreationResponse> implements AlertTypeCreationResponder {
    private final ObjectMapper objectMapper;

    @Override
    public void onAccept(AlertTypeCreationResponse response) {
        AlertTypeCreationViewModel viewModel = objectMapper.convertValue(response, AlertTypeCreationViewModel.class);
        this.entity = ResponseEntity.status(HttpStatus.CREATED).body(viewModel);
    }
}
