package com.lucianthomaz.alpr.alprintegration.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<PersistentUser, Integer> {
    Optional<PersistentUser> findByUsernameAndPassword(String username, String password);

    Optional<PersistentUser> findByUsername(String username);

    List<PersistentUser> findByLastModifiedLessThan(LocalDateTime dateTime);
}
