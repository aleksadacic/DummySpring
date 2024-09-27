package com.aleksadacic.dummyspring.services;

import com.aleksadacic.dummyspring.model.Cart;
import com.aleksadacic.dummyspring.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService extends AbstractService<Cart> {

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.repository = cartRepository;
    }
}
