package com.aleksadacic.dummyspring.services;

import com.aleksadacic.dummyspring.model.User;
import com.aleksadacic.dummyspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User> {

    @Autowired
    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }
}
