package com.SmartShop.SmartShop.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class FinancialEvent {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;
    private String eventType;
    private String details;

    @ManyToOne
    private Commande commande;

    // Getters & Setters
}
