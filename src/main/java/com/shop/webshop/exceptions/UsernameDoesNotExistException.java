package com.shop.webshop.exceptions;

public class UsernameDoesNotExistException extends RuntimeException{
    public UsernameDoesNotExistException(String userName) {
        super(String.format("User with username %s does not exist.", userName));
    }
}
