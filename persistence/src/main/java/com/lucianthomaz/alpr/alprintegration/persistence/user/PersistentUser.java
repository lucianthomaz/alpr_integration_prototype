package com.lucianthomaz.alpr.alprintegration.persistence.user;

import com.lucianthomaz.alpr.alprintegration.persistence.useralertacceptance.UserAlertAcceptance;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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

    @OneToMany(mappedBy = "user")
    Set<UserAlertAcceptance> userAlertAcceptances;
}
