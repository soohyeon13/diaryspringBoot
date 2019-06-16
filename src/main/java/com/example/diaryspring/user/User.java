package com.example.diaryspring.user;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "userinfo")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "username")
    String username;
    @Column(name = "userpaassword")
    String userpassword;

    public User(String username, String userpassword) {
        this.username = username;
        this.userpassword = userpassword;
    }

    @Override
    public String toString() {
        return String.format("User[id='%d',username='%s']",id,username);
    }
}
