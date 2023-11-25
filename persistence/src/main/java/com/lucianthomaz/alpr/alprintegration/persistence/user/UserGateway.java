package com.lucianthomaz.alpr.alprintegration.persistence.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucianthomaz.alpr.alprintegration.domain.User;
import com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface.UserRepository;
import lombok.AllArgsConstructor;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

    @Override
    public void updateFcmToken(int id, String fcmToken) {
        PersistentUser persistentUser = userJpaRepository.getReferenceById(id);
        persistentUser.setDeviceFcmToken(fcmToken);
        userJpaRepository.save(persistentUser);
    }

    @Override
    public boolean authenticate(String username, String password) {
       Optional<PersistentUser> perstentUser = userJpaRepository.findByUsernameAndPassword(username, password);
        return perstentUser.isPresent();
    }


}
