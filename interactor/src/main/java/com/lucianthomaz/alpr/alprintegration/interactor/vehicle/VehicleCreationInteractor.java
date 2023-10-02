package com.lucianthomaz.alpr.alprintegration.interactor.vehicle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.Vehicle;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.VehicleRepository;
import com.lucianthomaz.alpr.alprintegration.usecase.vehicle.create.VehicleCreationRequest;
import com.lucianthomaz.alpr.alprintegration.usecase.vehicle.create.VehicleCreationResponder;
import com.lucianthomaz.alpr.alprintegration.usecase.vehicle.create.VehicleCreationResponse;
import com.lucianthomaz.alpr.alprintegration.usecase.vehicle.create.VehicleCreationUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VehicleCreationInteractor implements VehicleCreationUseCase {
    private final VehicleRepository vehicleRepository;
    private final ObjectMapper objectMapper;
    @Override
    public void execute(VehicleCreationRequest request, VehicleCreationResponder responder) {
        Vehicle vehicle = objectMapper.convertValue(request, Vehicle.class);
        vehicle = vehicleRepository.create(vehicle);
        VehicleCreationResponse response = objectMapper.convertValue(vehicle, VehicleCreationResponse.class);
        responder.onAccept(response);
    }
}
