package com.lucianthomaz.alpr.alprintegration.controller.alert.complete;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.controller.BasePresenter;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.complete.AlertCompletionResponder;
import com.lucianthomaz.alpr.alprintegration.usecase.alert.complete.AlertCompletionResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public class AlertCompletionPresenter extends BasePresenter<AlertCompletionViewModel, AlertCompletionResponse> implements AlertCompletionResponder {
    private final ObjectMapper objectMapper;
    @Override
    public void onAccept(AlertCompletionResponse response) {
        AlertCompletionViewModel viewModel = objectMapper.convertValue(response, AlertCompletionViewModel.class);
        this.entity = ResponseEntity.ok(viewModel);
    }
}
