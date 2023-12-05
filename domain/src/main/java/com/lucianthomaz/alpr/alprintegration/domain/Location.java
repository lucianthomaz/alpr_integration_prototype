package com.lucianthomaz.alpr.alprintegration.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Location {
    private int id;
    private String address;
    private double latitude;
    private double longitude;
    private String direction;
}
