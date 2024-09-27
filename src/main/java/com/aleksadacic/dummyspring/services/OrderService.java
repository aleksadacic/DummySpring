package com.aleksadacic.dummyspring.services;

import com.aleksadacic.dummyspring.model.Order;
import com.aleksadacic.dummyspring.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends AbstractService<Order> {

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.repository = orderRepository;
    }
}
