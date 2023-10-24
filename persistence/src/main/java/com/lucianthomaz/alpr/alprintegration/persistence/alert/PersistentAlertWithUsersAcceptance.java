package com.lucianthomaz.alpr.alprintegration.persistence.alert;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "alert")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersistentAlertWithUsersAcceptance extends PersistentAlert{
    private String name;
    private String email;
    private Boolean accepted;
}
