package com.example.transaction_service.entity;

import com.example.transaction_service.enums.BankType;
import com.example.transaction_service.enums.CurrencyType;
import com.example.transaction_service.enums.TransactionStatus;
import com.example.transaction_service.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_transaction")
public class Transaction {

    @Id
    private String id;

    @Column(nullable = false)
    private String fromAccountNumber;

    @Column(nullable = false)
    private String toAccountNumber;

    @Column(nullable = false, precision = 20, scale = 2)
    private BigDecimal amount;

    private String description;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CurrencyType currency;

    @Column(nullable = false,unique = true)
    private String referenceCode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BankType bankType;

    private String destinationBankCode;
    @PrePersist
    public void prePersist(){
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
        if(this.timestamp == null){
            this.timestamp = LocalDateTime.now();
        }
        if (this.bankType == null) {
            this.bankType = BankType.INTERNAL;
        }
    }
}
