package com.example.diaryspring.dto;

import com.example.diaryspring.daycalendar.DayCalendar;
import lombok.Data;

@Data
public class DayCalendarDto {
    private String title, eventLocation, event_Subject, eventDescription, eventStart;
    Integer user_id;
}
