package com.example.diaryspring.user;

import com.example.diaryspring.vo.GetMeVO;
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

    @GetMapping(value = "/creat")
    public User create(@RequestParam String username, @RequestParam String userpassword) {
        return userService.join(username,userpassword);
    }

    @GetMapping(value = "/list")
    public List<User> list() {
        List<User> userList = userService.userList();
        return userList;
    }

    @PostMapping(value = "/me")
    public GetMeVO getMe(@RequestHeader String Authorization) {
        return GetMeVO.builder().result(userService.exists(Authorization)).build();
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
