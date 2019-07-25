package com.example.diaryspring.memocalendar;


import com.example.diaryspring.user.User;
import lombok.*;

import javax.persistence.*;

@Entity(name = "memocalendar")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemoCalendar {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "memo_title")
    String memo_title;
    @Column(name = "memo_location")
    String memo_location;
    @Column(name = "memo_description")
    String memo_description;
    @Column(name = "memo_date")
    String memo_date;

    @ManyToOne(targetEntity = User.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "memo_user_id")
    private User user;

}
