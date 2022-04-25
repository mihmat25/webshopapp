package com.shop.webshop.service;

import com.shop.webshop.dto.userdto.UserCreateDto;
import com.shop.webshop.dto.userdto.UserFullDto;

import java.util.List;

public interface UserService {
    UserFullDto signUp(UserCreateDto userCreateDto);

    UserFullDto login(UserCreateDto userCreateDto);

    UserFullDto findById(Integer id);

    UserFullDto update(UserFullDto userFullDto, Integer userId);

    List<UserFullDto> findAll();

    UserFullDto findByUserName(String userName);

    UserFullDto create(UserCreateDto userCreateDto);

    UserFullDto findByEmail(String email);

    void delete(Integer id);
}
