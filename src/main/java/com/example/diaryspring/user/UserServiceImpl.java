package com.example.diaryspring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User join(String username, String userpassword) {
        return userRepository.save(User.builder().username(username).userpassword(userpassword).build());
    }

    @Override
    public User authentication(String token) {
        String[] split = token.split(" ");
        String type = split[0];
        String credential =split[1];

        User user  =null;

        if ("Basic".equalsIgnoreCase(type)) {
            String decoded = new String(Base64Utils.decodeFromString(credential));
            String[] usernameAndUserpassword = decoded.split(":");

            user = userRepository.findByusernameAnduserpassword(usernameAndUserpassword[0],
                    usernameAndUserpassword[1]);
        }
        return user;
    }

    @Override
    public User updatepassword(String token, String password) {
        User user = this.authentication(token);
        user.setUserpassword(password);
        return userRepository.save(user);
    }

    @Override
    public void withdraw(String token) {
        User user = this.authentication(token);
        userRepository.delete(user);
    }

    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }
}
