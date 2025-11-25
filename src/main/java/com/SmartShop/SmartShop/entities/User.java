package com.SmartShop.SmartShop.entities;


import com.SmartShop.SmartShop.enums.UserRole;
import jakarta.persistence.*;

@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToOne(mappedBy = "user")
    private Client client;

    // Getters & Setters
}
