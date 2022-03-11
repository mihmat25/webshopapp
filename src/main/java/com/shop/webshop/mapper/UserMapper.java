package com.shop.webshop.mapper;

import com.shop.webshop.dto.userdto.UserCreateDto;
import com.shop.webshop.dto.userdto.UserFullDto;
import com.shop.webshop.model.User;

public class UserMapper {
    public static User userToEntity(UserCreateDto userCreateDto) {
        User user = new User();
        user.setFirstName(userCreateDto.getFirstName());
        user.setLastName(userCreateDto.getLastName());
        user.setEmail(userCreateDto.getEmail());
        user.setPassword(userCreateDto.getPassword());
        user.setAddress(userCreateDto.getAddress());

        return user;
    }

    public static UserFullDto userToFullDto(User user) {
        UserFullDto userFullDto = new UserFullDto();
        userFullDto.setFirstName(user.getFirstName());
        userFullDto.setLastName(user.getLastName());
        userFullDto.setEmail(user.getEmail());
        userFullDto.setPassword(user.getPassword());
        userFullDto.setAddress(user.getAddress());

        return userFullDto;
    }
}
