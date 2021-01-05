package com.alikn.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addNewUser(@RequestBody @Valid User user){
        userService.addNewUser(user);
    }

    @GetMapping(path = "api/{user_id}/topics")
    public List<UserTopic> getAllTopicsForUser(@PathVariable("user_id") UUID userId){
        return userService.getAllTopicsForUser(userId);
    }

}
