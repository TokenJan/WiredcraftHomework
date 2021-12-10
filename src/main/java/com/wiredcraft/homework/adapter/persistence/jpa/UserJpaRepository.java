package com.wiredcraft.homework.adapter.persistence.jpa;

import com.wiredcraft.homework.adapter.persistence.po.UserPo;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserJpaRepository extends PagingAndSortingRepository<UserPo, Long> {

}
