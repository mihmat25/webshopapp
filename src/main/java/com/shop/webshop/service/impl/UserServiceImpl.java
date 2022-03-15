package com.shop.webshop.service.impl;

import com.shop.webshop.dto.userdto.UserCreateDto;
import com.shop.webshop.dto.userdto.UserFullDto;
import com.shop.webshop.mapper.UserMapper;
import com.shop.webshop.model.User;
import com.shop.webshop.repository.UserRepository;
import com.shop.webshop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;


    public UserServiceImpl(UserRepository userRepository, UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
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
    public User verifyUserName(String userName) {
        return userRepository.findByUserName(userName);
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

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void login(String userName, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        authenticationManager.authenticate(token);

        if (token.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(token);
            logger.debug(String.format("User %s logged in successfully!", userName));
        } else {
            logger.error(String.format("Error with %s authentication!", userName));
        }
    }
}
