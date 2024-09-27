package com.aleksadacic.dummyspring.repositories;

import com.aleksadacic.dummyspring.model.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@org.springframework.stereotype.Repository
public interface UserRepository extends Repository<User>, JpaSpecificationExecutor<User> {
    User findByName(String name);
}
