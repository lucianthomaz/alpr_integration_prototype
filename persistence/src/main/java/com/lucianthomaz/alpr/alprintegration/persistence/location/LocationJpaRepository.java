package com.lucianthomaz.alpr.alprintegration.persistence.location;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationJpaRepository extends JpaRepository<PersistentLocation, Integer> {
}
