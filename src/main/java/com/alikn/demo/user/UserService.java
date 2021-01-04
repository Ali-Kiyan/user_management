package com.alikn.demo.user;

import com.alikn.demo.EmailValidator;
import com.alikn.demo.exception.ApiRequestException;
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
    private final EmailValidator emailValidator;

    @Autowired
    public UserService(com.alikn.demo.user.userDataAccessService userDataAccessService, EmailValidator emailValidator) {
        this.userDataAccessService = userDataAccessService;
        this.emailValidator = emailValidator;
    }

    List<User> getAllUsers() {
        return userDataAccessService.selectAllUsers();
    }

    void addNewUser(UUID userId, User user) {
        UUID newUserId = Optional.ofNullable(userId).orElse(UUID.randomUUID());
        if(!emailValidator.test(user.getEmail())){
            throw new ApiRequestException(user.getEmail() + " is not Valid");
        }
        if(userDataAccessService.isEmailTaken(user.getEmail())){
            throw new ApiRequestException(user.getEmail() + " is taken");
        }
        userDataAccessService.insertUser(newUserId, user);
    }

    void addNewUser(User user) {
        addNewUser(null, user);
    }

    List<UserTopic> getAllTopicsForUser(UUID userId){
        return userDataAccessService.selectAllUserTopics(userId);
    }


}
