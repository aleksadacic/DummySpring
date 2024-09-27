package com.aleksadacic.dummyspring.services;

import com.aleksadacic.dummyspring.model.Payment;
import com.aleksadacic.dummyspring.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService extends AbstractService<Payment> {

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.repository = paymentRepository;
    }
}
