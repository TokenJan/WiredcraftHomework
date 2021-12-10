package com.wiredcraft.homework.domain.service

import com.wiredcraft.homework.domain.dto.UserDto
import com.wiredcraft.homework.domain.model.User
import com.wiredcraft.homework.domain.repository.UserRepository
import com.wiredcraft.homework.exception.EntityNotFoundException
import spock.lang.Specification

import java.time.LocalDate

class UserDomainServiceTest extends Specification {

    def userRepository = Mock(UserRepository)
    def userDomainService = new UserDomainService(userRepository)

    void "should update user given update attributes"() {
        given:
        def id = 1L
        def name = "Jack"
        def address = "Shanghai"
        def description = "this is description"
        def dateOfBirth = LocalDate.of(1993, 6, 5)
        def userDto = [
            name: name,
            address: address,
            description: description,
            dateOfBirth: dateOfBirth,
        ] as UserDto
        def foundUser = new User("fake name", LocalDate.MAX, "Beijing", "no description")
        userRepository.findById(id) >> Optional.of(foundUser)

        when:
        userDomainService.update(id, userDto)

        then:
        noExceptionThrown()
        1 * userRepository.save() {
            it.name == name
            it.dob == dateOfBirth
            it.address == address
            it.description == description
        }
    }

    void "should throw EntityNotFoundException when update user given user id not found"() {
        given:
        def id = 1L
        def name = "Jack"
        def address = "Shanghai"
        def description = "this is description"
        def dateOfBirth = LocalDate.of(1993, 6, 5)
        def userDto = [
                name: name,
                address: address,
                description: description,
                dateOfBirth: dateOfBirth,
        ] as UserDto
        userRepository.findById(id) >> Optional.empty()

        when:
        userDomainService.update(id, userDto)

        then:
        thrown(EntityNotFoundException)
    }
}
