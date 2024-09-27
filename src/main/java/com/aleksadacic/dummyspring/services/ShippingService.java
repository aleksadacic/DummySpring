package com.aleksadacic.dummyspring.services;

import com.aleksadacic.dummyspring.model.Shipping;
import com.aleksadacic.dummyspring.repositories.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService extends AbstractService<Shipping> {

    @Autowired
    public ShippingService(ShippingRepository shippingRepository) {
        this.repository = shippingRepository;
    }
}
