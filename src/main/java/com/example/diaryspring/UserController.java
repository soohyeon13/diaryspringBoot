package com.example.diaryspring;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping(path="/add",consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User add(@RequestBody User user) {
        User userData = userRepository.save(user);
        return userData;
    }

    @GetMapping(path = "/view/{id}")
    public User view(@PathVariable int id) {
        Optional<User> userData = userRepository.findById(id);
        if (userData.isPresent()) {
            return userData.get();
        }else return null;
    }

    @GetMapping("/list")
    public List<User> list() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        System.out.println("id=" + id);
        userRepository.deleteById(id);
        return "redirect:/user/list";
    }

    @PutMapping("/edit/{id}")
    public User edit(User user) {
        User userData = userRepository.save(user);
        return userData;
    }
}
