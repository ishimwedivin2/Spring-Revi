package com.login.login.service;


import com.login.login.model.User;
import com.login.login.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
        return userRepository.save(user);
    }
//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username).orElse(null);
//    }
//    public boolean existsByUsername(String username) {
//
//    }
    public Optional<User> login(String username, String password) {
        return userRepository.findByUsername(username).filter(user -> user.getPassword().equals(password));
    }




}
