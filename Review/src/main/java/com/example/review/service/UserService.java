package com.example.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.review.model.User;
import com.example.review.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUserProfiles() {
        return userRepository.findAll();
    }
    public User register(User user) {
        return userRepository.save(user);
    }
    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }
    public User updateUserProfile(int id, User user){
        User use = getUserById(id);
        if (use!=null) {
            use.setUsername(user.getUsername());
            use.setPassword(user.getPassword());
            return userRepository.save(user);
        }
        return null;
    }
    public String deleteUserProfile(int id){
        if(getUserById(id)!=null){
            userRepository.deleteById(id);
            return "Deleted";
        }
        return "Id not found";
    }
}