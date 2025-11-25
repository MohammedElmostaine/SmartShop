package com.SmartShop.SmartShop.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderItemDTO {
    private Long id;
    private Long productId;
    private String productName;
    private BigDecimal unitPriceHT;
    private int quantity;
    private BigDecimal lineTotal;
}

