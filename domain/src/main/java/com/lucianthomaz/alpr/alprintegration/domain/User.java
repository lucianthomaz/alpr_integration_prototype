package com.lucianthomaz.alpr.alprintegration.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    private int id;
    private String name;
    private String email;
    private String username;
    private String password;
    private Double lastKnownLatitude;
    private Double lastKnownLongitude;
    private String deviceFcmToken;
}
