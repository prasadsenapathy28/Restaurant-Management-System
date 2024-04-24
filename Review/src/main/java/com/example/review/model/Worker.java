package com.example.review.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Worker {

    @Id
    private int id;
    private String name;
    private String role;
    private double salaryAllotted;
    private LocalDate dateJoined = LocalDate.now();
}