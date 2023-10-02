package com.lucianthomaz.alpr.alprintegration.controller.vehicle.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.controller.BasePresenter;
import com.lucianthomaz.alpr.alprintegration.usecase.vehicle.create.VehicleCreationResponder;
import com.lucianthomaz.alpr.alprintegration.usecase.vehicle.create.VehicleCreationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public class VehicleCreationPresenter extends BasePresenter<VehicleCreationViewModel, VehicleCreationResponse> implements VehicleCreationResponder {
    private final ObjectMapper objectMapper;

    @Override
    public void onAccept(VehicleCreationResponse response) {
        VehicleCreationViewModel viewModel = objectMapper.convertValue(response, VehicleCreationViewModel.class);
        this.entity = ResponseEntity.status(HttpStatus.CREATED).body(viewModel);
    }
}
