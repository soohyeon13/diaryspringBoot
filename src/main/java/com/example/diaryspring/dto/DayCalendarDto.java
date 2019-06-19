package com.example.diaryspring.dto;

import com.example.diaryspring.daycalendar.DayCalendar;
import lombok.Data;

@Data
public class DayCalendarDto {
    DayCalendar dayCalendar;
    Integer user_id;
}
