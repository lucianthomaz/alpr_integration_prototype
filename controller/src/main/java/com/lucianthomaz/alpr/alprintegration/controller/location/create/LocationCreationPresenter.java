package com.lucianthomaz.alpr.alprintegration.controller.location.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.controller.BasePresenter;
import com.lucianthomaz.alpr.alprintegration.usecase.location.create.LocationCreationResponder;
import com.lucianthomaz.alpr.alprintegration.usecase.location.create.LocationCreationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public class LocationCreationPresenter extends BasePresenter<LocationCreationViewModel, LocationCreationResponse> implements LocationCreationResponder {
    private final ObjectMapper objectMapper;

    @Override
    public void onAccept(LocationCreationResponse response) {
        LocationCreationViewModel viewModel = objectMapper.convertValue(response, LocationCreationViewModel.class);
        this.entity = ResponseEntity.status(HttpStatus.CREATED).body(viewModel);
    }
}
