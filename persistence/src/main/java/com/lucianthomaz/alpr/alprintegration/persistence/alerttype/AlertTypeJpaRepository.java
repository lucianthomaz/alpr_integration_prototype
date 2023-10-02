package com.lucianthomaz.alpr.alprintegration.persistence.alerttype;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertTypeJpaRepository extends JpaRepository<PersistentAlertType, Integer> {
}
