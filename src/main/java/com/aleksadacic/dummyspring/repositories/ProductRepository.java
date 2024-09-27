package com.aleksadacic.dummyspring.repositories;

import com.aleksadacic.dummyspring.model.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@org.springframework.stereotype.Repository
public interface ProductRepository extends Repository<Product>, JpaSpecificationExecutor<Product> {
    Product findByName(String name);
}
