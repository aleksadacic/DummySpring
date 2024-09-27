package com.aleksadacic.dummyspring.services;

import com.aleksadacic.dummyspring.model.Product;
import com.aleksadacic.dummyspring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends AbstractService<Product> {

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.repository = productRepository;
    }
}
