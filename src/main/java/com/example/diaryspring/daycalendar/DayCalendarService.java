package com.example.diaryspring.daycalendar;


import com.example.diaryspring.payload.DayCalendarPayLoad;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface DayCalendarService {

    List<DayCalendar> findAllByUserId(Integer user_id);

    DayCalendar updateCalendar(DayCalendar dayCalendar);

    void deleteCalendar(Integer id);

    DayCalendar addCalendar(DayCalendarPayLoad dayCalendarPayLoad);

    List<DayCalendar> calendarList();

}
