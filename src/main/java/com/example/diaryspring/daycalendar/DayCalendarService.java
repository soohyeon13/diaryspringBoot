package com.example.diaryspring.daycalendar;


import com.example.diaryspring.dto.DayCalendarDto;

import java.util.List;

public interface DayCalendarService {

    List<DayCalendar> findAllByUserId(Integer user_id);

    DayCalendar updateCalendar(DayCalendar dayCalendar);

    void deleteCalendar(Integer id);

    DayCalendar addCalendar(DayCalendarDto dayCalendarDto);

    List<DayCalendar> calendarList();

}