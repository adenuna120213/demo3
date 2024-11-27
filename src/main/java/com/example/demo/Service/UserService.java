package com.example.demo.Service;

import com.example.demo.Model.User;

import java.util.List;

public interface UserService {
    User findById(String Id);
    User saveUser(User user);
    void deleteUserById(String Id);
    List<User> getAllUsers();
    User findByLogin(String login);
}
