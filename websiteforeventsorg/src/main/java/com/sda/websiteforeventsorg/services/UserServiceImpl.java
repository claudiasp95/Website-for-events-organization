package com.sda.websiteforeventsorg.services;


import com.sda.websiteforeventsorg.entities.Participation;
import com.sda.websiteforeventsorg.entities.User;
import com.sda.websiteforeventsorg.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.getOne(id);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);

    }

    @Override
    public User updateUser(User user, long id) {
        try{
            Optional <User> newUser =Optional.ofNullable(user);
            User oldUser = userRepository.findById(id)
                    .orElseThrow(()->new RuntimeException("User not found."));
            oldUser.setUsername(newUser.map(User::getUsername).orElse(oldUser.getUsername()));
            oldUser.setPassword(newUser.map(User::getPassword).orElse(oldUser.getPassword()));
            oldUser.setEmail(newUser.map(User::getEmail).orElse(oldUser.getEmail()));
            oldUser.setFirstName(newUser.map(User::getFirstName).orElse(oldUser.getFirstName()));
            oldUser.setLastName(newUser.map(User::getLastName).orElse(oldUser.getLastName()));
            oldUser.setDateOfBirth(newUser.map(User::getDateOfBirth).orElse(oldUser.getDateOfBirth()));

            return userRepository.save(oldUser);

        }catch (Exception e ){
            throw new RuntimeException("User can`t be found");
        }
    }

    @Override
    public void deleteUserById(long id) {

    }
}
