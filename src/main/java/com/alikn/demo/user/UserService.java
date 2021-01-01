package com.alikn.demo.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

// Instantiate to get injected into User Controller
//@Component
@Service
public class UserService {

    public List<User> getAllUsers(){
        return List.of(new User(UUID.randomUUID(), "David", "Roberts", "Davidroberts@gmail.com", User.Gender.MALE),
                new User(UUID.randomUUID(), "Audrey", "Johnson", "Audreyjohnson@gmail.com", User.Gender.FEMALE));
    }

}
