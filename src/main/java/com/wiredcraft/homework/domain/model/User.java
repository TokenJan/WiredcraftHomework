package com.wiredcraft.homework.domain.model;

import com.wiredcraft.homework.domain.valueobject.UserId;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class User {

    private UserId id;

    private String name;

    // date of birth
    private LocalDate dob;

    private String address;

    private String description;

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


}
