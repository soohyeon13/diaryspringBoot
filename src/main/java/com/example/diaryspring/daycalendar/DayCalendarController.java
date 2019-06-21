package com.example.diaryspring.daycalendar;


import com.example.diaryspring.dto.DayCalendarDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/daycalendar")
@Slf4j
public class DayCalendarController {
    private final DayCalendarService dayCalendarService;

    @Autowired
    public DayCalendarController(DayCalendarService dayCalendarService) {
        this.dayCalendarService = dayCalendarService;
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DayCalendar addCalendar(@RequestBody DayCalendarDto dayCalendarDto) {
        return dayCalendarService.addCalendar(dayCalendarDto);
    }

    @GetMapping(value = "/list")
    public List<DayCalendar> list() {
        List<DayCalendar> dayCalendarList = dayCalendarService.calendarList();
        return dayCalendarList;
    }

    @GetMapping(value = "/{user_id}")
    public List<DayCalendar> findAllByUserId(@PathVariable Integer user_id) {
        List<DayCalendar> dayCalendarList = dayCalendarService.findAllByUserId(user_id);
        return dayCalendarList;
    }

    @DeleteMapping
    public void deleteCalendar(@RequestHeader Integer id) {
        dayCalendarService.deleteCalendar(id);
    }

    @PutMapping(value = "/{id}")
    public DayCalendar updateCalendar(DayCalendar dayCalendar) {
        return dayCalendarService.updateCalendar(dayCalendar);
    }
}