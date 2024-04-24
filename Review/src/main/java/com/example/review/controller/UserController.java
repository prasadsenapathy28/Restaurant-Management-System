package com.example.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.review.model.User;
import com.example.review.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userProfileService;

    @GetMapping("/getallusers")
    public List<User> getAllUserProfiles() {
        return userProfileService.getAllUserProfiles();
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userProfileService.register(user);
    }

    @PutMapping("update/{id}")
    public String updateUserProfile(@PathVariable int id, @RequestBody User userProfile){
        if(userProfileService.updateUserProfile(id, userProfile)!=null)
            return "Updated";
        else 
            return "Id Not found";
    }

    @DeleteMapping("delete/{id}")
    public String deleteUserProfile(@PathVariable int id) {
        return userProfileService.deleteUserProfile(id);
    }
}

