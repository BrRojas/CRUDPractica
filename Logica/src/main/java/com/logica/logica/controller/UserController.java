package com.logica.logica.controller;

import com.logica.logica.model.User;
import com.logica.logica.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImp userServiceImp;

    @PostMapping
    public User crateUser(@RequestBody User user){
        return userServiceImp.createUser(user);
    };


    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return userServiceImp.findByID(id);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userServiceImp.findAllUsers();
    }

    @DeleteMapping
    public void deleteUserById(@PathVariable Long id){
        userServiceImp.deleteUserById(id);
    }
}
