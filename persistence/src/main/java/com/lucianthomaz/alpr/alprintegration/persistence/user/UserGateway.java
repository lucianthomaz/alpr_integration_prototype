package com.lucianthomaz.alpr.alprintegration.persistence.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.User;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserGateway implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final ObjectMapper objectMapper;


    @Override
    public User create(User user) {
        PersistentUser persistentUser = PersistentUser.builder()
                .email("lucian@email.com")
                .nome("Lucian")
                .senha("senha")
                .usuario("lucian")
                .build();
        userJpaRepository.save(persistentUser);
        return User.builder().build();
    }

    @Override
    public User getUser(int id) {
        PersistentUser persistentUser = userJpaRepository.getReferenceById(id);
        return User.builder().build();
    }
}
