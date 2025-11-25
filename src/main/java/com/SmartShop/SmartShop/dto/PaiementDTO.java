package com.SmartShop.SmartShop.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class PaiementDTO {
    private Long id;
    private Long commandeId;
    private int paymentSeq;
    private BigDecimal amount;
    private String type; // ESPECES, CHEQUE, VIREMENT
    private String status; // EN_ATTENTE, ENCAISSE, REJETE
    private LocalDate paymentDate;
    private LocalDate encashmentDate;
    private String reference;
    private String bank;
    private LocalDate dueDate; // Pour cheque/virement différé
}

