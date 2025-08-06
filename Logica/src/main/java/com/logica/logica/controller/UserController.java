package com.logica.logica.controller;

import com.logica.logica.dto.UserRequestDTO;
import com.logica.logica.dto.UserResponseDTO;
import com.logica.logica.model.User;
import com.logica.logica.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImp userServiceImp;

    @PostMapping
    public UserResponseDTO crateUser(@RequestBody UserRequestDTO dto){
        return userServiceImp.createUser(dto);
    };


    @GetMapping("/{id}")
    public UserResponseDTO findById(@PathVariable String dto){
        return userServiceImp.findByUser(dto);
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
