package com.logica.logica.service;

import com.logica.logica.dto.UserRequestDTO;
import com.logica.logica.dto.UserResponseDTO;
import com.logica.logica.model.User;
import com.logica.logica.repository.UserRepository;
import com.logica.logica.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
    public UserResponseDTO upDateUser(String user, String password) {
        User found = userRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Usuario " + user + " no encontrado"));

        found.setPassword(password);

        userRepository.save(found);

            return userMapper.toDTO(found);
    }

    @Override
    public  List<UserResponseDTO> findAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public String deleteUserById(String user) {
    User found = userRepository.findByUser(user)
            .orElseThrow(() -> new RuntimeException("Usuario " + user + " no encontrado"));
    userRepository.delete(found);
    return "Usuario eliminado correctamente";
    }
}
