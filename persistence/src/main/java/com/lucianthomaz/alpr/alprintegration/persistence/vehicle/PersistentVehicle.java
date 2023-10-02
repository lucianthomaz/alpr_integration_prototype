package com.lucianthomaz.alpr.alprintegration.persistence.vehicle;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicle")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersistentVehicle {
    @Id
    private String license_plate;
    private String model;
    private String color;
}
