package com.logica.logica.service;

import com.logica.logica.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    @Autowired

    User createUser(User user);
    User findByID(Long id);//por ahora pongo un optional.
    User upDateUser(Long id,String mail,String password);
    List<User> findAllUsers();
    void deleteUserById(Long id);

}
