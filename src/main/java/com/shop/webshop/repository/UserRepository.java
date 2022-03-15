package com.shop.webshop.repository;

import com.shop.webshop.dto.userdto.UserFullDto;
import com.shop.webshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findById(Integer id);

    User findByUserName(String userName);

    Optional<User> findByEmail(String email);
}
