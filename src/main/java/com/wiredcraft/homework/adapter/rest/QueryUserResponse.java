package com.wiredcraft.homework.adapter.rest;

import com.wiredcraft.homework.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryUserResponse {

    private Long id;

    private String name;

    private LocalDate dateOfBirth;

    private String address;

    private String description;

    private LocalDateTime createdAt;

    public static QueryUserResponse from(User user) {
        return new QueryUserResponse(user.getId().getId(), user.getName(), user.getDob(), user.getAddress(), user.getDescription(), user.getCreatedAt());
    }
}
