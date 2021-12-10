package com.wiredcraft.homework.domain.repository;

import com.wiredcraft.homework.domain.model.User;

import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findById(Long id);
}
