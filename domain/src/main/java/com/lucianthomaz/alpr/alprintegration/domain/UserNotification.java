package com.lucianthomaz.alpr.alprintegration.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserNotification {
    private String name;
    private String email;
    private Boolean accepted;
}
