package com.aleksadacic.dummyspring.services;

import com.aleksadacic.dummyspring.model.Category;
import com.aleksadacic.dummyspring.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends AbstractService<Category> {

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.repository = categoryRepository;
    }
}
