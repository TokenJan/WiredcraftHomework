package com.wiredcraft.homework.domain.repository;

import com.wiredcraft.homework.domain.model.User;

public interface UserRepository {

    User save(User user);
}
