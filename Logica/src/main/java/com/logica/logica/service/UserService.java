package com.logica.logica.service;

import com.logica.logica.dto.UserRequestDTO;
import com.logica.logica.dto.UserResponseDTO;

import java.util.List;


public interface UserService {


    UserResponseDTO createUser(UserRequestDTO user);
    UserResponseDTO findByUser(String user);
    UserResponseDTO upDateUser(String user,String password);
    List<UserResponseDTO> findAllUsers();
    String deleteUserById(String user);

}
