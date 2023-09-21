package com.lucianthomaz.alpr.alprintegration;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlertType {
    private int id;
    private String name;
    private String description;
}
