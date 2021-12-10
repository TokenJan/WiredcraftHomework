package com.wiredcraft.homework.adapter.rest;

import com.wiredcraft.homework.domain.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CreateUserCommand {

    @NotNull
    private String name;
    private String address;
    private String description;
    @Past
    private LocalDate dateOfBirth;

    public User toDomain() {
        return new User(name, dateOfBirth, address, description);
    }
}
