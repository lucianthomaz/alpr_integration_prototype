package com.lucianthomaz.alpr.alprintegration.interactor.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.User;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.UserRepository;
import com.lucianthomaz.alpr.alprintegration.usecase.user.create.UserCreationRequest;
import com.lucianthomaz.alpr.alprintegration.usecase.user.create.UserCreationResponder;
import com.lucianthomaz.alpr.alprintegration.usecase.user.create.UserCreationResponse;
import com.lucianthomaz.alpr.alprintegration.usecase.user.create.UserCreationUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserCreationInteractor implements UserCreationUseCase {
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;


    @Override
    public void execute(UserCreationRequest request, UserCreationResponder responder) {
        User user = objectMapper.convertValue(request, User.class);
        user = userRepository.create(user);
        UserCreationResponse response = objectMapper.convertValue(user, UserCreationResponse.class);
        responder.onAccept(response);
    }
}
