package com.example.review.model;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResOrder {
    @Id
    private int id;
    private int userid;
    private String items;
    private LocalDateTime createdAt = LocalDateTime.now();
}
