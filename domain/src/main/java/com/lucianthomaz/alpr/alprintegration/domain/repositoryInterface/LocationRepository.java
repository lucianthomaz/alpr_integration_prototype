package com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface;

import com.lucianthomaz.alpr.alprintegration.domain.Location;

public interface LocationRepository {

    Location create(Location location);

    Location getLocation(int id);
}
