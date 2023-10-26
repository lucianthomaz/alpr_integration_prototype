package com.lucianthomaz.alpr.alprintegration.persistence.alert;

import com.lucianthomaz.alpr.alprintegration.domain.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "alert")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersistentAlertWithUsersAcceptance{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int locationId;
    private String licensePlate;
    private int alertTypeId;
    private LocalDateTime dateTime;
    private String details;
    private StatusEnum status;
    private String pictureUrl;
    private String name;
    private String email;
    private Boolean accepted;
}
