package com.lucianthomaz.alpr.alprintegration.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class UserAlert {
    private int alertId;
    private int userId;
    private Boolean accepted;
}
