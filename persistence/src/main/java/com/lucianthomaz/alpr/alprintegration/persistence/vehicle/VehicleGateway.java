package com.lucianthomaz.alpr.alprintegration.persistence.vehicle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.Vehicle;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.VehicleRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VehicleGateway implements VehicleRepository {
    private final VehicleJpaRepository jpaRepository;
    private final ObjectMapper objectMapper;

    public Vehicle create(Vehicle vehicle) {
        PersistentVehicle persistentVehicle = objectMapper.convertValue(vehicle, PersistentVehicle.class);
        return objectMapper.convertValue(jpaRepository.save(persistentVehicle), Vehicle.class);
    }

    @Override
    public Vehicle getVehicle(String licence_place) {
        return objectMapper.convertValue(jpaRepository.getReferenceById(licence_place), Vehicle.class);
    }
}
