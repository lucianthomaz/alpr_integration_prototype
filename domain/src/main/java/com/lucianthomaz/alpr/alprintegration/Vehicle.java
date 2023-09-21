package com.lucianthomaz.alpr.alprintegration;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Vehicle {
    private String licensePlate;
    private String model;
    private String color;
}
