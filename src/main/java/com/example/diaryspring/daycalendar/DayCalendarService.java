package com.example.diaryspring.daycalendar;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DayCalendarService {
    private final DayCalendarRepo dayCalendarRepo;

    public List<DayCalendar> findAll() {
        return dayCalendarRepo.findAll();
    }

    public Optional<DayCalendar> findById(Integer id) {
        return dayCalendarRepo.findById(id);
    }

    public DayCalendar save(DayCalendar dayCalendar) {
        return dayCalendarRepo.save(dayCalendar);
    }

    public void deleteById(Integer id) {
        dayCalendarRepo.deleteById(id);
    }

}
