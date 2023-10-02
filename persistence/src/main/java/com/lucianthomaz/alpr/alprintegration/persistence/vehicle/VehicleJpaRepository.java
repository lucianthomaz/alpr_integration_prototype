package com.lucianthomaz.alpr.alprintegration.persistence.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleJpaRepository extends JpaRepository<PersistentVehicle, String> {
}
