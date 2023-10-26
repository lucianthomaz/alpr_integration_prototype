package com.lucianthomaz.alpr.alprintegration.persistence.alert;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlertJpaRepository extends JpaRepository<PersistentAlert, Integer> {

    @Query(value = """
            SELECT
            AL.id,
            AL.location_id,
            AL.license_plate,
            AL.alert_type_id,
            AL.date_time,
            AL.details,
            AL.status,
            AL.picture_url,
            U.name,
            U.email,
            UA.Accepted
            FROM
            alert AL
            LEFT JOIN user_alert UA ON
            AL.ID = UA.ALERT_ID
            LEFT JOIN `user` U ON UA.user_id = U.id
            WHERE
            UA.USER_ID = ?1
            """, nativeQuery = true)
    List<PersistentAlertWithUsersAcceptance> findAllByUserId(int userId);
}
