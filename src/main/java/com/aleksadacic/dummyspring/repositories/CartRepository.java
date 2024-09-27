package com.aleksadacic.dummyspring.repositories;

import com.aleksadacic.dummyspring.model.Cart;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@org.springframework.stereotype.Repository
public interface CartRepository extends Repository<Cart>, JpaSpecificationExecutor<Cart> {
}
