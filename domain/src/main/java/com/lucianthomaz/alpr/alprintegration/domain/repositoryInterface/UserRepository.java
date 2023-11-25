package com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface;

import com.lucianthomaz.alpr.alprintegration.domain.User;

import java.util.List;

public interface UserRepository {
    User create(User user);

    User getUser(int id);

    List<User> getUsers(List<Integer> ids);

    void updateFcmToken(int id, String fcmToken);

    boolean authenticate(String username, String password);
}
