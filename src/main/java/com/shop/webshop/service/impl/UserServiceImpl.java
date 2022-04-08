package com.shop.webshop.service.impl;

import com.shop.webshop.dto.userdto.UserCreateDto;
import com.shop.webshop.dto.userdto.UserFullDto;
import com.shop.webshop.exceptions.UserNameAlreadyUsedException;
import com.shop.webshop.exceptions.UsernameDoesNotExistException;
import com.shop.webshop.mapper.UserMapper;
import com.shop.webshop.model.Order;
import com.shop.webshop.model.Role;
import com.shop.webshop.model.Status;
import com.shop.webshop.model.User;
import com.shop.webshop.repository.OrderRepository;
import com.shop.webshop.repository.UserRepository;
import com.shop.webshop.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public UserServiceImpl(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
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
        User user = userRepository.findByUserName(userName);
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
    public UserFullDto update(UserFullDto userFullDto, Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with id: " + userId + " not found!"));
        user.setEmail(userFullDto.getEmail());
        user.setAddress(userFullDto.getAddress());
        User updatedUser = userRepository.save(user);
        return UserMapper.userToFullDto(updatedUser);
    }

    @Override
    public void delete(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id: " + id + " not found!"));
        userRepository.delete(user);
    }

    @Override
    public UserFullDto signUp(UserCreateDto userCreateDto) {
        if (userRepository.existsByUserName(userCreateDto.getUserName())) {
            throw new UserNameAlreadyUsedException(userCreateDto.getUserName());
        }

        User user = userRepository.save(UserMapper.userToEntity(userCreateDto));
        user.setRole(Role.USER);
        Order order = new Order();
        order.setStatus(Status.ACTIVE);
        order.setUser(user);
        user.setCurrentOrder(order);
        userRepository.save(user);

        return UserMapper.userToFullDto(user);
    }

    @Override
    public UserFullDto login(UserCreateDto userCreateDto) {
        User user = userRepository.findByUserName(userCreateDto.getUserName());
        if (user != null && user.getUserPassword().equals(userCreateDto.getPassword())) {
            return UserMapper.userToFullDto(user);
        } else {
            throw new UsernameDoesNotExistException(userCreateDto.getUserName());
        }
    }
}
