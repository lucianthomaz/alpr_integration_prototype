package com.lucianthomaz.alpr.alprintegration.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<PersistentUser, Integer> {
}
