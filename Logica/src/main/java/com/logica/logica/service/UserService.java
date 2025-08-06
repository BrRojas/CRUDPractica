package com.logica.logica.service;

import com.logica.logica.dto.UserRequestDTO;
import com.logica.logica.dto.UserResponseDTO;
import com.logica.logica.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    @Autowired
    UserResponseDTO createUser(UserRequestDTO user);
    UserResponseDTO findByUser(String dto);
    User upDateUser(Long id,String mail,String password);
    List<User> findAllUsers();
    void deleteUserById(Long id);

}
