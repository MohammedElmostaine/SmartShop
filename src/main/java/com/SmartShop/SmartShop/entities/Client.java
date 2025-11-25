package com.SmartShop.SmartShop.entities;

import com.SmartShop.SmartShop.enums.CustomerTier;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private CustomerTier tier;

    private int totalOrders;
    private BigDecimal totalSpent;

    private LocalDate firstOrderDate;
    private LocalDate lastOrderDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "client")
    private List<Commande> commandes;

    // Getters & Setters
}
