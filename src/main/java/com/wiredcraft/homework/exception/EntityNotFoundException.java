package com.wiredcraft.homework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class EntityNotFoundException extends ClientException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
