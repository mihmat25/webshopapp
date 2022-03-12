package com.shop.webshop.service;

import com.shop.webshop.dto.userdto.UserCreateDto;
import com.shop.webshop.dto.userdto.UserFullDto;

import java.util.List;

public interface UserService {
    UserFullDto create(UserCreateDto userCreateDto);

    UserFullDto findById(Integer id);

    UserFullDto findByUserName(String userName);

    UserFullDto findByEmail(String email);

    List<UserFullDto> findAll();

    UserFullDto update(UserCreateDto userCreateDto);

    void delete(Integer id);
}
