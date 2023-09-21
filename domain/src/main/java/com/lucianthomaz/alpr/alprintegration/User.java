package com.lucianthomaz.alpr.alprintegration;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class User {
    private int id;
    private String name;
    private String email;
    private String username;
    private String password;
    private List<Alert> alertsNotification;
}
