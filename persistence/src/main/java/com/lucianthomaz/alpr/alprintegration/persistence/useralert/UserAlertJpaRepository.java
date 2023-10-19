package com.lucianthomaz.alpr.alprintegration.persistence.useralert;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAlertJpaRepository extends JpaRepository<PersistentUserAlert, UserAlertId> {
}
