package com.lucianthomaz.alpr.alprintegration.interactor.location;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.Location;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.LocationRepository;
import com.lucianthomaz.alpr.alprintegration.usecase.location.create.LocationCreationRequest;
import com.lucianthomaz.alpr.alprintegration.usecase.location.create.LocationCreationResponder;
import com.lucianthomaz.alpr.alprintegration.usecase.location.create.LocationCreationResponse;
import com.lucianthomaz.alpr.alprintegration.usecase.location.create.LocationCreationUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LocationCreationInteractor implements LocationCreationUseCase {
    private final LocationRepository locationRepository;
    private final ObjectMapper objectMapper;
    @Override
    public void execute(LocationCreationRequest request, LocationCreationResponder responder) {
        Location location = objectMapper.convertValue(request, Location.class);
        location = locationRepository.create(location);
        LocationCreationResponse response = objectMapper.convertValue(location, LocationCreationResponse.class);
        responder.onAccept(response);
    }
}
