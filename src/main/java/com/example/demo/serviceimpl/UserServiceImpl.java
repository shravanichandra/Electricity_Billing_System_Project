package com.example.demo.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // Save a new User
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Get all Users
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a User by ID
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    // Update an existing User
    @Override
    public User updateUser(Long id, User userDetails) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));

        existingUser.setUserName(userDetails.getUserName());
        existingUser.setUserAddress(userDetails.getUserAddress());
        existingUser.setUserContactNo(userDetails.getUserContactNo());
        existingUser.setUserEmail(userDetails.getUserEmail());

        return userRepository.save(existingUser);
    }

    // Delete a User by ID
    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }
}



