package com.bookkeeping.repository;

import com.bookkeeping.entity.SalesReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesReceiptRepository extends JpaRepository<SalesReceipt, Long> {
    SalesReceipt findByReceiptNumber(String receiptNumber);
}