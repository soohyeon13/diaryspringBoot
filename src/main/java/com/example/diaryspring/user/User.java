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
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer user_id;
    @Column(name = "username")
    String username;
    @Column(name = "userpaassword")
    String userpassword;

    @Override
    public String toString() {
        return String.format("User[id='%d',username='%s']",user_id,username);
    }
}
