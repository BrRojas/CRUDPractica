package com.logica.logica.util;

import com.logica.logica.dto.UserRequestDTO;
import com.logica.logica.dto.UserResponseDTO;
import com.logica.logica.model.User;

public class UserMapper {

    public static User toEntity(UserRequestDTO dto) {
        User user = new User();
        user.setUser(dto.getUser());
        user.setPassword(dto.getPassword());
        return user;
    }

    public static UserResponseDTO toDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setUser(user.getUser());
        return dto;
    }

}
