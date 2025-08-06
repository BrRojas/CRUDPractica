package com.logica.logica.service;

import com.logica.logica.dto.UserRequestDTO;
import com.logica.logica.dto.UserResponseDTO;
import com.logica.logica.model.User;
import com.logica.logica.repository.UserRepository;
import com.logica.logica.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = userMapper.toEntity(dto);
        User saved = userRepository.save(user);
        return userMapper.toDTO(saved);
    }

    @Override
    public UserResponseDTO findByUser(String dto) {
        User found = userRepository.findByUser(dto)
                .orElseThrow(() -> new RuntimeException("Usuario " + dto + " no encontrado"));

        return userMapper.toDTO(found);
    }

    @Override
    public User upDateUser(Long id, String mail, String password) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("User by ID" + id + " not Found"));

            user.setUser(mail);
            user.setPassword(password);

            return userRepository.save(user);
    }

    @Override
    public  List<User> findAllUsers() {
        return userRepository.findAll();

    }

    @Override
    public void deleteUserById(Long id) {
    userRepository.deleteById(id);
    }
}
