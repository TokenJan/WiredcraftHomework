package com.wiredcraft.homework.adapter.rest;

import com.wiredcraft.homework.domain.dto.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UpdateUserCommand {

    private String name;
    private String address;
    private String description;
    private LocalDate dateOfBirth;

    public UserDto toDto() {
        return new UserDto(name, address, description, dateOfBirth);
    }
}
