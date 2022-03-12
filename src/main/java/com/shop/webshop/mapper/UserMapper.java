package com.shop.webshop.mapper;

import com.shop.webshop.dto.userdto.UserCreateDto;
import com.shop.webshop.dto.userdto.UserFullDto;
import com.shop.webshop.model.User;

public class UserMapper {
    public static User userToEntity(UserCreateDto userCreateDto) {
        User user = new User();
        user.setUserName(userCreateDto.getUserName());
        user.setEmail(userCreateDto.getEmail());
        user.setPassword(userCreateDto.getPassword());
        user.setAddress(userCreateDto.getAddress());

        return user;
    }

    public static UserFullDto userToFullDto(User user) {
        UserFullDto userFullDto = new UserFullDto();
        userFullDto.setUserName(user.getUserName());
        userFullDto.setEmail(user.getEmail());
        userFullDto.setAddress(user.getAddress());

        return userFullDto;
    }
}
