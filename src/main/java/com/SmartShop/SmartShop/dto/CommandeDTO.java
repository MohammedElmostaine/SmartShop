package com.SmartShop.SmartShop.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CommandeDTO {
    private Long id;
    private Long clientId;
    private List<OrderItemDTO> orderItems;
    private BigDecimal subtotalHT;
    private BigDecimal discountAmount;
    private BigDecimal htAfterDiscount;
    private BigDecimal tvaAmount;
    private BigDecimal totalTTC;
    private String codePromo;
    private String status; // PENDING, CONFIRMED, etc
    private BigDecimal amountRemaining;
}

