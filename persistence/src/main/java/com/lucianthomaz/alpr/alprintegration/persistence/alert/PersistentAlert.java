package com.lucianthomaz.alpr.alprintegration.persistence.alert;

import com.lucianthomaz.alpr.alprintegration.domain.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "alert")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersistentAlert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int locationId;
    private String licensePlate;
    private int alertTypeId;
    private LocalDateTime creationDate;
    private String details;
    private String status;
    private String pictureUrl;
    private LocalDateTime lastModified;
    private int lastModifiedBy;
}
