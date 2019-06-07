package com.example.diaryspring.daycalendar;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "daycalendar")
@Getter
@Setter
public class DayCalendar {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

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

    @Column(name = "event_end")
    String eventEnd;


}
