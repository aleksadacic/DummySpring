package com.aleksadacic.dummyspring.repositories;

import com.aleksadacic.dummyspring.model.Order;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@org.springframework.stereotype.Repository
public interface OrderRepository extends Repository<Order>, JpaSpecificationExecutor<Order> {
}
