package com.example.diaryspring.daycalendar;

import com.example.diaryspring.user.User;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "daycalendar")
@Getter
@Setter
public class DayCalendar {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

//    @Column(name = "user_id")
//    Integer user_id;

    @Column(name = "username")
    String username;

    @Column(name = "today")
    String today;

    @Column(name = "title")
    String title;

    @Column(name = "event_location")
    String eventLocation;

    @Column(name = "event_description")
    String eventDescription;

    @Column(name = "event_start")
    String eventStart;

//    @ManyToMany
//    @JoinTable(name = "calendar_user",
//            joinColumns = @JoinColumn(name = "calendar_id"),
//            inverseJoinColumns = @JoinColumn (name= "user_id"))
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
