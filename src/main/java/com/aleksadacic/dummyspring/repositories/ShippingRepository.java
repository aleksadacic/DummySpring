package com.aleksadacic.dummyspring.repositories;

import com.aleksadacic.dummyspring.model.Shipping;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@org.springframework.stereotype.Repository
public interface ShippingRepository extends Repository<Shipping>, JpaSpecificationExecutor<Shipping> {
}
