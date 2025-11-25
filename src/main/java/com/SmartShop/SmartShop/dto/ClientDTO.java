package com.SmartShop.SmartShop.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
public class ClientDTO {
    private Long id;
    private String name;
    private String email;
    private String tier; // BASIC / SILVER / GOLD / PLATINUM
    private int totalOrders;
    private BigDecimal totalSpent;
    private LocalDate firstOrderDate;
    private LocalDate lastOrderDate;

}
