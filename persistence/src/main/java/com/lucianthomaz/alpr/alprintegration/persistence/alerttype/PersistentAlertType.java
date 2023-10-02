package com.lucianthomaz.alpr.alprintegration.persistence.alerttype;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alert_type")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersistentAlertType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
}
