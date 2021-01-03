package com.alikn.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {

    private final UserService userService;

    //Dependency Injection
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        throw new IllegalStateException("fadsfadsfadsfasdfadsfasdf asfsdfas");
//        return userService.getAllUsers();
    }

}
