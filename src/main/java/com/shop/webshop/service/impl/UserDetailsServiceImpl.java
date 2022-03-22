package com.shop.webshop.service.impl;

import com.shop.webshop.config.UserDetails;
import com.shop.webshop.model.User;
import com.shop.webshop.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User repoUser = userRepository.findByUserName(username);
        UserDetails securityUserDetails = new UserDetails(repoUser);
        return securityUserDetails;


    }
}
