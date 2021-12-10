package com.wiredcraft.homework.domain.service;

import com.wiredcraft.homework.domain.model.User;
import com.wiredcraft.homework.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDomainService {

    private final UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }
}
