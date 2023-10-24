package com.lucianthomaz.alpr.alprintegration.persistence.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.User;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.UserRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserGateway implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final ObjectMapper objectMapper;


    @Override
    public User create(User user) {
        PersistentUser persistentUser = objectMapper.convertValue(user, PersistentUser.class);
        return objectMapper.convertValue(userJpaRepository.save(persistentUser), User.class);
    }

    @Override
    public User getUser(int id) {
        PersistentUser persistentUser = userJpaRepository.getReferenceById(id);
        return objectMapper.convertValue(persistentUser, User.class);
    }

    @Override
    public List<User> getUsers(List<Integer> ids) {
        List<PersistentUser> persistentUsers = userJpaRepository.findAllById(ids);
        return persistentUsers.stream().map(x -> objectMapper.convertValue(x, User.class)).toList();
    }


}
