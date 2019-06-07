package com.example.diaryspring.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="userinfo")
@Getter
@Setter
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "username")
    String username;
    @Column(name = "userpaassword")
    String userpassword;
}
