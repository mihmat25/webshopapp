package com.shop.webshop.service.impl;

import com.shop.webshop.dto.userdto.UserCreateDto;
import com.shop.webshop.dto.userdto.UserFullDto;
import com.shop.webshop.mapper.UserMapper;
import com.shop.webshop.model.User;
import com.shop.webshop.repository.UserRepository;
import com.shop.webshop.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserFullDto create(UserCreateDto userCreateDto) {
        User user = UserMapper.userToEntity(userCreateDto);
        User savedUser = userRepository.save(user);
        return UserMapper.userToFullDto(savedUser);
    }

    @Override
    public UserFullDto findById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id: " + id + " not found!"));
        return UserMapper.userToFullDto(user);
    }

    @Override
    public UserFullDto findByUserName(String userName) {
        User user = userRepository.findByUserName(userName).orElseThrow(() -> new RuntimeException("User with username: " + userName + " not found!"));
        return UserMapper.userToFullDto(user);
    }

    @Override
    public UserFullDto findByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User with email: " + email + " not found"));
        return UserMapper.userToFullDto(user);
    }

    @Override
    public List<UserFullDto> findAll() {
        List<UserFullDto> userList = new ArrayList<>();
        userRepository.findAll().forEach(entity -> {
            userList.add(UserMapper.userToFullDto(entity));
        });
        return userList;
    }

    @Override
    public UserFullDto update(UserCreateDto userCreateDto) {
        User user = UserMapper.userToEntity(userCreateDto);
        User updatedUser = userRepository.save(user);
        return UserMapper.userToFullDto(updatedUser);
    }

    @Override
    public void delete(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id: " + id + " not found!"));
        userRepository.delete(user);
    }
}
