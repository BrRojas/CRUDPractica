package com.logica.logica.controller;

import com.logica.logica.dto.UserRequestDTO;
import com.logica.logica.dto.UserResponseDTO;
import com.logica.logica.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImp userServiceImp;

    @PostMapping
    public ResponseEntity<UserResponseDTO> crateUser(@RequestBody UserRequestDTO dto){
        return ResponseEntity.ok(userServiceImp.createUser(dto));
    };

    @GetMapping("/{user}")
    public ResponseEntity<UserResponseDTO> findByUser(@PathVariable String dto){
        return ResponseEntity.ok(userServiceImp.findByUser(dto));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userServiceImp.findAllUsers());
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUserById(@PathVariable String user){
        return ResponseEntity.ok(userServiceImp.deleteUserById(user));
    }
}
