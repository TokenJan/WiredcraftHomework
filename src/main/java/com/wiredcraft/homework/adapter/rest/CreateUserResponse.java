package com.wiredcraft.homework.adapter.rest;

import com.wiredcraft.homework.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponse {

    private Long id;

    public static CreateUserResponse from(User user) {
        return new CreateUserResponse(user.getId().getId());
    }
}
