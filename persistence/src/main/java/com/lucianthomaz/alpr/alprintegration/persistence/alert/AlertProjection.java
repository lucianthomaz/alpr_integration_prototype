package com.lucianthomaz.alpr.alprintegration.persistence.alert;

import java.time.LocalDateTime;

public interface AlertProjection {
    Integer getId();
    Integer getLocationId();
    String getLicensePlate();
    Integer getAlertTypeId();
    LocalDateTime getDateTime();
    String getDetails();
    String getStatus();
    String getPictureUrl();
    String getName();
    String getEmail();
    Boolean getAccepted();
}
