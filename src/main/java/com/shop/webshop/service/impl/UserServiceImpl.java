package com.shop.webshop.service.impl;

import com.shop.webshop.repository.UserRepository;
import com.shop.webshop.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
