package com.alikn.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Instantiate to get injected into User Controller
//@Component
@Service
public class UserService {
    private final userDataAccessService userDataAccessService;

    @Autowired
    public UserService(com.alikn.demo.user.userDataAccessService userDataAccessService) {
        this.userDataAccessService = userDataAccessService;
    }

    List<User> getAllUsers() {
        return userDataAccessService.selectAllUsers();
    }

    void addNewUser(UUID userId, User user) {
        UUID newUserId = Optional.ofNullable(userId).orElse(UUID.randomUUID());
        userDataAccessService.insertUser(newUserId, user);
    }

    void addNewUser(User user) {
        addNewUser(null, user);
    }
}
