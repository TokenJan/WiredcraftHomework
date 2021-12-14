package com.wiredcraft.homework.adapter.persistence.jpa

import com.wiredcraft.homework.adapter.persistence.po.UserPo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

import java.time.LocalDate

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase
class UserJpaRepositoryTest extends Specification {

    @Autowired
    private UserJpaRepository userJpaRepository

    void "should save user with id, createdAt and updatedAt given user domain"() {
        given:
        def name = "Jack"
        def dob = LocalDate.of(1993, 6, 5)
        def address = "Shanghai"
        def description = "this is description"
        def userPo = [
            name: name,
            address: address,
            description: description,
            dateOfBirth: dob,
        ] as UserPo

        when:
        def savedUser = userJpaRepository.save(userPo)


        then:
        savedUser.id == 1L
        savedUser.name == name
        savedUser.dateOfBirth == dob
        savedUser.description == description
        savedUser.address == address
        savedUser.createdAt != null
        savedUser.updatedAt != null
    }

}
