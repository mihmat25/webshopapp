package com.shop.webshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Username already exists")
public class UserNameAlreadyUsedException extends RuntimeException {
    public UserNameAlreadyUsedException(String userName) {
        super(String.format("User with username %s is already used.", userName));
    }
}
