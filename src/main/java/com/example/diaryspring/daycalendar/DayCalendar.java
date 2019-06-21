package com.example.diaryspring.daycalendar;

import com.example.diaryspring.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "daycalendar")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DayCalendar {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "title")
    String title;

    @Column(name = "event_location")
    String eventLocation;

    @Column(name = "event_subject")
    String event_Subject;

    @Column(name = "event_description")
    String eventDescription;

    @Column(name = "event_start")
    String eventStart;

    @ManyToOne(targetEntity = User.class , fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

}