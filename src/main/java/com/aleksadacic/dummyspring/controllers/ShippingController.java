package com.aleksadacic.dummyspring.controllers;

import com.aleksadacic.dummyspring.model.Shipping;
import com.aleksadacic.dummyspring.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @PostMapping
    public ResponseEntity<Shipping> createShipping(@RequestBody Shipping shipping) {
        Shipping savedShipping = shippingService.save(shipping);
        return ResponseEntity.ok(savedShipping);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shipping> getShippingById(@PathVariable Long id) {
        Optional<Shipping> shipping = shippingService.findById(id);
        return shipping.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Shipping> getAllShipping() {
        return shippingService.findAll();
    }

    @GetMapping("/paged")
    public Page<Shipping> getAllShippingPaged(Pageable pageable) {
        return shippingService.findAll(pageable);
    }

    @GetMapping("/filtered")
    public List<Shipping> getFilteredShipping(Specification<Shipping> specification, Sort sort) {
        return shippingService.findAll(specification, sort);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shipping> updateShipping(@PathVariable Long id, @RequestBody Shipping shipping) {
        Shipping updatedShipping = shippingService.update(id, shipping);
        return ResponseEntity.ok(updatedShipping);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShipping(@PathVariable Long id) {
        shippingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
