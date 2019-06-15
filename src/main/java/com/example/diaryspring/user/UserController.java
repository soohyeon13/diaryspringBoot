package com.example.diaryspring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestParam String username,String userpassword) {
        return userService.join(username,userpassword);
    }

    @GetMapping(value = "/list")
    public List<User> list() {
        List<User> userList = userService.userList();
        return userList;
    }

    @GetMapping(value = "/me")
    public User getMe(@RequestHeader String authorization) {
        return userService.authentication(authorization);
    }

    @PutMapping(value = "/me")
    public User updatePassword(@RequestHeader String authorization, @RequestParam String userpassword) {
        return userService.updatepassword(authorization,userpassword);
    }

    @DeleteMapping
    public void withdraw(@RequestHeader String authorization) {
        userService.withdraw(authorization);
    }
}
