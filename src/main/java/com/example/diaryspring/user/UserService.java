package com.example.diaryspring.user;


import com.example.diaryspring.user.exception.UnauthorizedException;

import java.util.List;

public interface UserService {
    User join(String username, String userpassword);

    boolean exists(String token);

    User authentication(String token) throws UnauthorizedException;

    User updatepassword(String token,String password);

    void withdraw(String token);

    List<User> userList();

    User findByid(Integer id);
}
