package com.bookkeeping.controller;

import com.bookkeeping.entity.Vendor;
import com.bookkeeping.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendors")
@CrossOrigin(origins = "*")
public class VendorController {

    @Autowired
    private VendorRepository vendorRepository;

    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable Long id) {
        Optional<Vendor> vendor = vendorRepository.findById(id);
        return vendor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable Long id, @RequestBody Vendor vendorDetails) {
        Optional<Vendor> vendor = vendorRepository.findById(id);
        if (vendor.isPresent()) {
            Vendor v = vendor.get();
            v.setName(vendorDetails.getName());
            v.setEmail(vendorDetails.getEmail());
            v.setPhone(vendorDetails.getPhone());
            v.setAddress(vendorDetails.getAddress());
            v.setCity(vendorDetails.getCity());
            v.setState(vendorDetails.getState());
            v.setZipCode(vendorDetails.getZipCode());
            v.setAccountNumber(vendorDetails.getAccountNumber());
            return ResponseEntity.ok(vendorRepository.save(v));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVendor(@PathVariable Long id) {
        if (vendorRepository.existsById(id)) {
            vendorRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}