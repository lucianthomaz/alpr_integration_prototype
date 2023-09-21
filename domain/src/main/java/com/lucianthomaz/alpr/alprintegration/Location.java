package com.lucianthomaz.alpr.alprintegration;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Location {
    private int id;
    private String address;
    private float latitude;
    private float longitude;
    private String direction;
}
