package com.aleksadacic.dummyspring.repositories;

import com.aleksadacic.dummyspring.model.Category;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@org.springframework.stereotype.Repository
public interface CategoryRepository extends Repository<Category>, JpaSpecificationExecutor<Category> {
    Category findByName(String name);
}
