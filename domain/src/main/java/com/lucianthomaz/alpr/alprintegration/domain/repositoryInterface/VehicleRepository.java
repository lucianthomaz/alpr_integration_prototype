package com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface;

import com.lucianthomaz.alpr.alprintegration.domain.Vehicle;

public interface VehicleRepository {
    Vehicle create(Vehicle vehicle);

    Vehicle getVehicle(String licence_place);
}
