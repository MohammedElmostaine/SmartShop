package com.SmartShop.SmartShop.model;


import com.SmartShop.SmartShop.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Commande {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    private BigDecimal subtotalHT;
    private BigDecimal discountAmount;
    private BigDecimal htAfterDiscount;
    private BigDecimal tvaAmount;
    private BigDecimal totalTTC;

    private String codePromo;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private BigDecimal amountRemaining;

    private int tvaRate = 20;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paiement> paiements;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    private List<FinancialEvent> events;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}


