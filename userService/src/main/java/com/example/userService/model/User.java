package com.example.userService.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

@Id
@GeneratedValue(strategy = GenerationType.UUID)
@Column(name = "user_id")
 private String userId;
 
 private String name;

 @Column(unique = true, nullable = false)
 private String email;

 @Column(nullable = false)
 private String password;

 @Column(columnDefinition = "json")
 private String address;

 @Column(name = "created_at")
 private LocalDateTime createdAt;

}
