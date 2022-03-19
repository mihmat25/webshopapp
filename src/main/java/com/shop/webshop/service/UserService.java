package com.shop.webshop.service;

import com.shop.webshop.dto.userdto.UserCreateDto;
import com.shop.webshop.dto.userdto.UserFullDto;
import com.shop.webshop.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserFullDto create(UserCreateDto userCreateDto);

    UserFullDto findById(Integer id);

    UserFullDto findByUserName(String userName);

    UserFullDto findByEmail(String email);

    User verifyUserName(String userName);

    List<UserFullDto> findAll();

    UserFullDto update(UserCreateDto userCreateDto);

    void delete(Integer id);

    void save(User user);

    void login(String userName, String password);
}
