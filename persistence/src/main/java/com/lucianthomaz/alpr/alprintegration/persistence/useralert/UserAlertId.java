package com.lucianthomaz.alpr.alprintegration.persistence.useralert;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserAlertId implements Serializable {

    @Column(name = "alert_id")
    private int alertId;

    @Column(name = "user_id")
    private int userId;
}
