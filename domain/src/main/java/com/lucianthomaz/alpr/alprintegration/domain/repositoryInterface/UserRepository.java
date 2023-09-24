package com.lucianthomaz.alpr.alprintegration.domain.repositoryInterface;

import com.lucianthomaz.alpr.alprintegration.domain.User;

public interface UserRepository {
    User create(User user);

    User getUser(int id);
}
