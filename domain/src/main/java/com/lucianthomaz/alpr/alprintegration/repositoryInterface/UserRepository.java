package com.lucianthomaz.alpr.alprintegration.repositoryInterface;

import com.lucianthomaz.alpr.alprintegration.User;

public interface UserRepository {
    User create(User user);

    User getUser(int id);
}
