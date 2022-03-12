package com.shop.webshop.controller;

import com.shop.webshop.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/webshopapp/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // TODO @Post  pe /users cu usename si parola intr-un obiect de tipul
    // return a user object also with id
}
