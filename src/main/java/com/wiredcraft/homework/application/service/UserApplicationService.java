package com.wiredcraft.homework.application.service;

import com.wiredcraft.homework.adapter.rest.CreateUserCommand;
import com.wiredcraft.homework.domain.model.User;
import com.wiredcraft.homework.domain.service.UserDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserApplicationService {

    private final UserDomainService userDomainService;

    @Transactional
    public User create(CreateUserCommand command) {
        User user = command.toDomain();
        return userDomainService.create(user);
    }
}
