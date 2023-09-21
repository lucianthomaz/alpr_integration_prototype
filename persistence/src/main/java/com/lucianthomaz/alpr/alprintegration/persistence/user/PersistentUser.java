package com.lucianthomaz.alpr.alprintegration.persistence.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "Usuario")
@Data
@Builder
public class PersistentUser {
    @Id
    private int id;
    private String nome;
    private String email;
    private String usuario;
    private String senha;
}
