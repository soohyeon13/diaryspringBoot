package com.example.diaryspring.payload;

import com.example.diaryspring.daycalendar.DayCalendar;
import lombok.Data;

@Data
public class DayCalendarPayLoad {
    DayCalendar dayCalendar;
    Integer user_id;
}
