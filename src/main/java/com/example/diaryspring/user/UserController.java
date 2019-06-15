package com.example.diaryspring.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

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

//    @PostMapping(path="/add",consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public User add(@RequestBody User user) {
//        User userData = userRepository.save(user);
//        return userData;
//    }
//
//    @GetMapping(path = "/view/{id}")
//    public User view(@PathVariable int id) {
//        Optional<User> userData = userRepository.findById(id);
//        if (userData.isPresent()) {
//            return userData.get();
//        }else return null;
//    }
//
//    @GetMapping("/list")
//    public List<User> list() {
//        List<User> userList = userRepository.findAll();
//        return userList;
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String delete(@PathVariable int id) {
//        System.out.println("id=" + id);
//        userRepository.deleteById(id);
//        return "redirect:/user/list";
//    }
//
//    @PutMapping("/edit/{id}")
//    public User edit(User user) {
//        User userData = userRepository.save(user);
//        return userData;
//    }
}
