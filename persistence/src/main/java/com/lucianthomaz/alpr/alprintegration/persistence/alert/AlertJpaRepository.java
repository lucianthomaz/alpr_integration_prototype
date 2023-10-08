package com.lucianthomaz.alpr.alprintegration.persistence.alert;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertJpaRepository extends JpaRepository<PersistentAlert, Long> {
}
