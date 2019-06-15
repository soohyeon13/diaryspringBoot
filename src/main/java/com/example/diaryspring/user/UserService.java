package com.example.diaryspring.user;


import java.util.List;

public interface UserService {
    User join(String username, String userpassword);

    User authentication(String token);

    User updatepassword(String token,String password);

    void withdraw(String token);

    List<User> userList();
}
