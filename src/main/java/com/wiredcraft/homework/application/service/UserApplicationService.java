package com.wiredcraft.homework.application.service;

import com.wiredcraft.homework.adapter.rest.CreateUserCommand;
import com.wiredcraft.homework.adapter.rest.UpdateUserCommand;
import com.wiredcraft.homework.domain.dto.UserDto;
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

    // FIXME: add distributed lock with id to avoid update lost
    @Transactional
    public void update(Long id, UpdateUserCommand command) {
        UserDto userDto = command.toDto();
        userDomainService.update(id, userDto);
    }

    // FIXME: add distributed lock with id to avoid update lost
    @Transactional
    public void delete(Long id) {
        userDomainService.delete(id);
    }

    @Transactional(readOnly = true)
    public User query(Long id) {
        return userDomainService.query(id);
    }
}
