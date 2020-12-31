package com.alikn.demo.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("users")
public class UserController {
    @GetMapping
    public List<User> getAllUsers(){
        return List.of(new User(UUID.randomUUID(), "David", "Roberts", "Davidroberts@gmail.com", User.Gender.MALE),
                new User(UUID.randomUUID(), "Audrey", "Johnson", "Audreyjohnson@gmail.com", User.Gender.FEMALE));
    }
}
