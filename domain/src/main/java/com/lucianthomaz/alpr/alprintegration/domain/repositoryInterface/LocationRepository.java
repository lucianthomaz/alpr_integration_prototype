package com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface;

import com.lucianthomaz.alpr.alprintegration.domain.Location;

import java.util.Optional;

public interface LocationRepository {

    Location create(Location location);

    Optional<Location> getLocation(int id);
}
