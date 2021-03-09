package com.sda.websiteforeventsorg.controllers;

import com.sda.websiteforeventsorg.entities.User;
import com.sda.websiteforeventsorg.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;

    @GetMapping()
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUsers(@PathVariable("id") long id){
        return userService.getUserById(id);
    }
    @PostMapping()
    public void saveUser(@RequestBody User user){
        userService.createUser(user);
    }
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") long id){
        return userService.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id){
        userService.deleteUserById(id);
    }



}
