package com.logica.logica.service;

import com.logica.logica.dto.UserRequestDTO;
import com.logica.logica.dto.UserResponseDTO;
import com.logica.logica.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    @Autowired
    UserResponseDTO createUser(UserRequestDTO user);
    UserResponseDTO findByUser(String user);
    UserResponseDTO upDateUser(String user,String password);
    List<UserResponseDTO> findAllUsers();
    String deleteUserById(String user);

}
