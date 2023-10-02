package com.lucianthomaz.alpr.alprintegration.persistence.location;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.Location;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.LocationRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LocationGateway implements LocationRepository {
    private final LocationJpaRepository jpaRepository;
    private final ObjectMapper objectMapper;
    @Override
    public Location create(Location location) {
        PersistentLocation persistentLocation = objectMapper.convertValue(location, PersistentLocation.class);
        return objectMapper.convertValue(jpaRepository.save(persistentLocation), Location.class);
    }

    @Override
    public Location getLocation(int id) {
        return objectMapper.convertValue(jpaRepository.getReferenceById(id), Location.class);
    }

}
