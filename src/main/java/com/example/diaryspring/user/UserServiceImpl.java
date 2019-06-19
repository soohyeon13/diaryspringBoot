package com.example.diaryspring.user;

import com.example.diaryspring.user.exception.AlreadyExistsException;
import com.example.diaryspring.user.exception.UnauthorizedException;
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
        User user = new User();
        if (user != null) {
            throw new AlreadyExistsException("Duplicate username");
        }
        return userRepository.save(User.builder().username(username).userpassword(userpassword).build());
    }

    @Override
    public boolean exists(String token) {
        try {
            User user = authentication(token);
            if(user != null) return true;
        } catch (UnauthorizedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User authentication(String token) throws UnauthorizedException {
        try {
            String[] split = token.split(" ");
            String type = split[0];
            String credential = split[1];

            if ("Basic".equalsIgnoreCase(type)) {
                String decoded = new String(Base64Utils.decodeFromString(credential));
                String[] usernameAndPassword = decoded.split(":");

                User user = userRepository.findByusernameAnduserpassword(usernameAndPassword[0], usernameAndPassword[1]);
//                return userRepository.existsByusernameAnduserpassword(usernameAndPassword[0], usernameAndPassword[1]);
                if (user == null) {
                    throw new UnauthorizedException("Invalid credentials");
                } else {
                    return user;
                }

            } else {
                throw new UnauthorizedException("Unsupported type: " + type);

            }
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ex) {
            throw new UnauthorizedException("Invalid credentials");
        }
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

    @Override
    public User findByid(Integer id) {
        return userRepository.findById(id).get();
    }
}
