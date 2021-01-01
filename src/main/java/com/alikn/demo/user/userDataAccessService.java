package com.alikn.demo.user;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class userDataAccessService {
    public List<User> selectAllUsers(){
        return List.of(new User(UUID.randomUUID(), "David", "Roberts", "Davidroberts@gmail.com", User.Gender.MALE),
                new User(UUID.randomUUID(), "Audrey", "Johnson", "Audreyjohnson@gmail.com", User.Gender.FEMALE));
    }
}
