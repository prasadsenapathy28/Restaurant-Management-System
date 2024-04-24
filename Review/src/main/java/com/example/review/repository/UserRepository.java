package com.example.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.review.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    
}