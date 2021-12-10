package com.wiredcraft.homework.domain.service;

import com.wiredcraft.homework.adapter.rest.QueryUserResponse;
import com.wiredcraft.homework.domain.dto.UserDto;
import com.wiredcraft.homework.domain.model.User;
import com.wiredcraft.homework.domain.repository.UserRepository;
import com.wiredcraft.homework.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDomainService {

    private final UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public void update(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("user with id: [%d] not found", id)));
        user.updateWith(userDto);
        userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }

    public User query(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("user with id: [%d] not found", id)));
    }
}
