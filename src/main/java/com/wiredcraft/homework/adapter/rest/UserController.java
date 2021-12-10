package com.wiredcraft.homework.adapter.rest;

import com.wiredcraft.homework.application.service.UserApplicationService;
import com.wiredcraft.homework.common.CommonResponse;
import com.wiredcraft.homework.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserApplicationService userApplicationService;

    @PostMapping
    public CommonResponse<CreateUserResponse> create(@Valid @RequestBody CreateUserCommand command) {
        User user = userApplicationService.create(command);
        CreateUserResponse response = CreateUserResponse.from(user);
        return CommonResponse.withData(response);
    }
}
