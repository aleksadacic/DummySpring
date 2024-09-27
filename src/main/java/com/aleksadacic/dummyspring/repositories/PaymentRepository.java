package com.aleksadacic.dummyspring.repositories;

import com.aleksadacic.dummyspring.model.Payment;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@org.springframework.stereotype.Repository
public interface PaymentRepository extends Repository<Payment>, JpaSpecificationExecutor<Payment> {
}
