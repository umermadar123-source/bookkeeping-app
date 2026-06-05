package com.bookkeeping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentId;
    
    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = true)
    private Vendor vendor;
    
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = true)
    private Customer customer;

    private BigDecimal amount;
    
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    
    private String description;
    private LocalDateTime paymentDate;
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public enum PaymentMethod {
        CASH, CHECK, CREDIT_CARD, BANK_TRANSFER, OTHER
    }

    public enum PaymentStatus {
        PENDING, COMPLETED, FAILED, CANCELLED
    }
}