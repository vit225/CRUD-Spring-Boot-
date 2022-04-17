package com.example.demo.service;

import com.example.demo.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void saveUser(User user);

    List<User> findAll();

    void deleteById(long id);

    Optional<User> findById(long id);

    void updateUser(User updateUser);
}
