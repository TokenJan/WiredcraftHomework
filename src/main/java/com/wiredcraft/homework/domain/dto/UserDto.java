package com.wiredcraft.homework.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserDto {

    private String name;
    private String address;
    private String description;
    private LocalDate dateOfBirth;

    public UserDto(String name, String address, String description, LocalDate dateOfBirth) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
    }
}
