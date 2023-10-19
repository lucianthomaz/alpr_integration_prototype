package com.lucianthomaz.alpr.alprintegration.persistence.useralert;

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
@IdClass(UserAlertId.class)
public class PersistentUserAlert {

    @Column(name = "alert_id")
    @Id
    private int alertId;

    @Column(name = "user_id")
    @Id
    private int userId;

    private Boolean accepted;

}
