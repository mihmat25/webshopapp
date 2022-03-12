package com.shop.webshop.controller;


import com.shop.webshop.service.UserService;
import com.shop.webshop.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterController {
    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
    private final UserService userService;
    private  final UserValidator userValidator;

    public RegisterController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
}
