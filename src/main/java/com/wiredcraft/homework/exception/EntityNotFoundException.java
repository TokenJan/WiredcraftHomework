package com.wiredcraft.homework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends ClientException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
