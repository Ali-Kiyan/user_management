package com.alikn.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Instantiate to get injected into User Controller
//@Component
@Service
public class UserService {
    private final userDataAccessService userDataAccessService;

    @Autowired
    public UserService(com.alikn.demo.user.userDataAccessService userDataAccessService) {
        this.userDataAccessService = userDataAccessService;
    }

    public List<User> getAllUsers(){
        return userDataAccessService.selectAllUsers();
    }

}
