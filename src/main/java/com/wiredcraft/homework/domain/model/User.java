package com.wiredcraft.homework.domain.model;

import com.wiredcraft.homework.domain.dto.UserDto;
import com.wiredcraft.homework.domain.valueobject.UserId;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class User {

    private UserId id;

    private String name;

    // date of birth
    private LocalDate dob;

    private String address;

    private String description;

    private List<User> followees;

    private LocalDateTime createdAt;

    public User(String name, LocalDate dob, String address, String description) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.description = description;
    }

    public User(Long id, String name, LocalDate dob, String address, String description, LocalDateTime createdAt) {
        this.id = new UserId(id);
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.description = description;
        this.createdAt = createdAt;
    }


    public void updateWith(UserDto userDto) {
        this.name = userDto.getName();
        this.dob = userDto.getDateOfBirth();
        this.address = userDto.getAddress();
        this.description = userDto.getDescription();
    }
}
