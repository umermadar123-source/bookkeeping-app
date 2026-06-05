package com.bookkeeping.controller;

import com.bookkeeping.entity.SalesReceipt;
import com.bookkeeping.repository.SalesReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/sales-receipts")
@CrossOrigin(origins = "*")
public class SalesReceiptController {

    @Autowired
    private SalesReceiptRepository salesReceiptRepository;

    @GetMapping
    public List<SalesReceipt> getAllSalesReceipts() {
        return salesReceiptRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesReceipt> getSalesReceiptById(@PathVariable Long id) {
        Optional<SalesReceipt> receipt = salesReceiptRepository.findById(id);
        return receipt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public SalesReceipt createSalesReceipt(@RequestBody SalesReceipt receipt) {
        if (receipt.getReceiptNumber() == null) {
            receipt.setReceiptNumber("RCP-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        }
        if (receipt.getPaymentStatus() == null) {
            receipt.setPaymentStatus(SalesReceipt.PaymentStatus.PENDING);
        }
        return salesReceiptRepository.save(receipt);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalesReceipt> updateSalesReceipt(@PathVariable Long id, @RequestBody SalesReceipt receiptDetails) {
        Optional<SalesReceipt> receipt = salesReceiptRepository.findById(id);
        if (receipt.isPresent()) {
            SalesReceipt r = receipt.get();
            r.setCustomer(receiptDetails.getCustomer());
            r.setTotalAmount(receiptDetails.getTotalAmount());
            r.setTaxAmount(receiptDetails.getTaxAmount());
            r.setDiscountAmount(receiptDetails.getDiscountAmount());
            r.setPaymentStatus(receiptDetails.getPaymentStatus());
            r.setNotes(receiptDetails.getNotes());
            return ResponseEntity.ok(salesReceiptRepository.save(r));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalesReceipt(@PathVariable Long id) {
        if (salesReceiptRepository.existsById(id)) {
            salesReceiptRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}