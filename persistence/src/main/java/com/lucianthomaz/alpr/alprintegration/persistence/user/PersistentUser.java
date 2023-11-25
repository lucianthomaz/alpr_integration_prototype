package com.lucianthomaz.alpr.alprintegration.persistence.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersistentUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String username;
    private String password;
    private Float lastKnownLatitude;
    private Float lastKnownLongitude;
    private String lastModified;
    private String deviceFcmToken;
}
