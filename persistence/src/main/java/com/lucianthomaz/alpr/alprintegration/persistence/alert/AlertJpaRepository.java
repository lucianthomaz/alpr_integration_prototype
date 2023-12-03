package com.lucianthomaz.alpr.alprintegration.persistence.alert;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface AlertJpaRepository extends JpaRepository<PersistentAlert, Integer> {

    @Query(value = """
            SELECT
            AL.id,
            AL.location_id as locationId,
            AL.license_plate as licensePlate,
            AL.alert_type_id as alertTypeId,
            AL.creation_date as creationDate,
            AL.details,
            AL.status,
            AL.picture_url as pictureUrl,
            U.name,
            U.email,
            UA.Accepted as accepted
            FROM
            alert AL
            LEFT JOIN user_alert UA ON
            AL.ID = UA.ALERT_ID
            LEFT JOIN `user` U ON UA.user_id = U.id
            WHERE
            UA.USER_ID = ?1
            """, nativeQuery = true)
    List<AlertProjection> findAllByUserId(int userId);

    List<PersistentAlert> findAllByCreationDateLessThanAndStatusEquals(LocalDateTime creationDate, String status);
}
