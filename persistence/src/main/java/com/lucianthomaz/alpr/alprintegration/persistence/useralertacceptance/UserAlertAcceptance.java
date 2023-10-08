package com.lucianthomaz.alpr.alprintegration.persistence.useralertacceptance;

import com.lucianthomaz.alpr.alprintegration.persistence.alert.PersistentAlert;
import com.lucianthomaz.alpr.alprintegration.persistence.user.PersistentUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_alert")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAlertAcceptance {

    @EmbeddedId
    UserAlertKey id;

    @ManyToOne
    @MapsId("alertId")
    @JoinColumn(name = "alert_id")
    PersistentAlert alert;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    PersistentUser user;

    private boolean accepted;

}
