package com.shop.webshop.controller;

import com.shop.webshop.dto.userdto.UserCreateDto;
import com.shop.webshop.dto.userdto.UserFullDto;
import com.shop.webshop.model.User;
import com.shop.webshop.service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/webshopapp/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserFullDto> create(@RequestBody UserCreateDto userCreateDto) {
        return new ResponseEntity<>(userService.signUp(userCreateDto), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserFullDto> login(@RequestBody UserCreateDto userCreateDto) {
        return new ResponseEntity<>(userService.login(userCreateDto), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<UserFullDto>> findAll() {
        List<UserFullDto> listOfUsers = userService.findAll();
        return ResponseEntity.ok(listOfUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserFullDto> getOne(@PathVariable Integer id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserFullDto> update(@PathVariable(name = "userId") Integer userId, @RequestBody UserFullDto userFullDto) {
        return new ResponseEntity<>(userService.update(userFullDto, userId), HttpStatus.OK);
    }
}
