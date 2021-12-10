package com.wiredcraft.homework.adapter.persistence.repository;

import com.wiredcraft.homework.adapter.persistence.jpa.UserJpaRepository;
import com.wiredcraft.homework.adapter.persistence.po.UserPo;
import com.wiredcraft.homework.domain.model.User;
import com.wiredcraft.homework.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User save(User user) {
        UserPo userPo = UserPo.fromDomain(user);
        return userJpaRepository.save(userPo).toDomain();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userJpaRepository.findById(id).map(UserPo::toDomain);
    }
}
