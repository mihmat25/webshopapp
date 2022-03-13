package com.shop.webshop.controller;

import com.shop.webshop.dto.userdto.UserFullDto;
import com.shop.webshop.model.User;
import com.shop.webshop.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/webshopapp/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<UserFullDto>> findAll() {
        List<UserFullDto> listOfUsers = userService.findAll();
        return ResponseEntity.ok(listOfUsers);
    }

    // TODO @Post  pe /users cu usename si parola intr-un obiect de tipul
    // return a user object also with id
}
