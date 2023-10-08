package com.lucianthomaz.alpr.alprintegration.persistence.useralertacceptance;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class UserAlertKey implements Serializable {

    @Column(name = "alert_id")
    private int alert_id;

    @Column(name = "user_id")
    private int user_id;
}
