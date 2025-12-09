package com.example.kello_demo_app.service;

import com.example.kello_demo_app.model.User;
import com.example.kello_demo_app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(Long id) {

        return userRepository.findById(id);
    }

    public User createUser(User user) {

        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findByTeam(String team) {
        return userRepository.findByTeam(team);
    }
}
