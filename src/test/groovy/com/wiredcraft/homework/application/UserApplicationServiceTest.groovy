package com.wiredcraft.homework.application

import com.wiredcraft.homework.adapter.rest.CreateUserCommand
import com.wiredcraft.homework.application.service.UserApplicationService
import com.wiredcraft.homework.domain.service.UserDomainService
import spock.lang.Specification

import java.time.LocalDate

class UserApplicationServiceTest extends Specification {

    UserDomainService userDomainService = Mock(UserDomainService)
    UserApplicationService userApplicationService = new UserApplicationService(userDomainService)

    void "should invoke createUser in domain service given CreateUserCommand"() {
        given:
        def name = "Jack"
        def address = "Shanghai"
        def description = "this is description"
        def dateOfBirth = LocalDate.of(1993, 6, 5)
        def command = [
            name: name,
            address: address,
            description: description,
            dateOfBirth: dateOfBirth,
        ] as CreateUserCommand

        when:
        userApplicationService.create(command)

        then:
        1 * userDomainService.create() {
            it.name == name
            it.dob == dateOfBirth
            it.address == address
            it.description == description
        }
    }
}
