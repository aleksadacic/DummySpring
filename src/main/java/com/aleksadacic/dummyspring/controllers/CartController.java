package com.aleksadacic.dummyspring.controllers;

import com.aleksadacic.dummyspring.model.Cart;
import com.aleksadacic.dummyspring.services.CartService;
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
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        Cart savedCart = cartService.save(cart);
        return ResponseEntity.ok(savedCart);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
        Optional<Cart> cart = cartService.findById(id);
        return cart.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.findAll();
    }

    @GetMapping("/paged")
    public Page<Cart> getAllCartsPaged(Pageable pageable) {
        return cartService.findAll(pageable);
    }

    @GetMapping("/filtered")
    public List<Cart> getFilteredCarts(Specification<Cart> specification, Sort sort) {
        return cartService.findAll(specification, sort);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart cart) {
        Cart updatedCart = cartService.update(id, cart);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        cartService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
