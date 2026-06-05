package com.bookkeeping.controller;

import com.bookkeeping.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private SalesReceiptRepository salesReceiptRepository;

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getDashboardStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalProducts", productRepository.count());
        stats.put("totalCustomers", customerRepository.count());
        stats.put("totalVendors", vendorRepository.count());
        stats.put("totalPayments", paymentRepository.count());
        stats.put("totalReceipts", salesReceiptRepository.count());
        return ResponseEntity.ok(stats);
    }
}