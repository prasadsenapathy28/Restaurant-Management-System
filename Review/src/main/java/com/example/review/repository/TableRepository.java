package com.example.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.review.model.ResTable;

@Repository
public interface TableRepository extends JpaRepository<ResTable,Integer>{

}