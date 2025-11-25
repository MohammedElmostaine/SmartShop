package com.SmartShop.SmartShop.model;

import com.SmartShop.SmartShop.enums.PaymentStatus;
import com.SmartShop.SmartShop.enums.PaymentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@Entity
public class Paiement {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int paymentSeq;
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaymentType type;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private LocalDate paymentDate;
    private LocalDate encashmentDate;
    private String reference;
    private String bank;
    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;

    @OneToOne
    private FinancialEvent event;

    // Getters & Setters
}

