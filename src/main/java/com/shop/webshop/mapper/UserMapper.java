package com.shop.webshop.mapper;

import com.shop.webshop.dto.userdto.UserCreateDto;
import com.shop.webshop.dto.userdto.UserFullDto;
import com.shop.webshop.model.User;

public class UserMapper {
    public static User userToEntity(UserCreateDto userCreateDto) {
        User user = new User();
        user.setUserName(userCreateDto.getUserName());
        user.setUserPassword(userCreateDto.getPassword());
        return user;
    }

    public static User userToUpdateEntity(UserFullDto userFullDto) {
        User user = new User();
        user.setEmail(userFullDto.getEmail());
        user.setAddress(userFullDto.getAddress());
        return user;
    }


    public static UserFullDto userToFullDto(User user) {
        return new UserFullDto(
                user.getId(),
                user.getUserName(),
                user.getEmail(),
                user.getAddress()
        );
    }
}
