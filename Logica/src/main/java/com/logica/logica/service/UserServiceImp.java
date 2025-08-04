package com.logica.logica.service;

import com.logica.logica.model.User;
import com.logica.logica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByID(Long id) {
        return userRepository.getById(id);
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
    public List<User> findAllUsers() {
        return userRepository.findAll();


    }

    @Override
    public void deleteUserById(Long id) {
    userRepository.deleteById(id);
    }
}
