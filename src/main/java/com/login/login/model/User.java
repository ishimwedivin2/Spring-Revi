package com.login.login.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role;  // "ADMIN" or "USER"





}
