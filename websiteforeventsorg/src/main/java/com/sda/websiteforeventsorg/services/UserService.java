package com.sda.websiteforeventsorg.services;

import com.sda.websiteforeventsorg.entities.Participation;
import com.sda.websiteforeventsorg.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(long id);
    void createUser(User user);
    User updateUser(User user, long id);
    void deleteUserById(long id);
}
