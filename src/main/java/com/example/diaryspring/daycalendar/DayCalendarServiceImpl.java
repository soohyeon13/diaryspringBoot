package com.example.diaryspring.daycalendar;

import com.example.diaryspring.dto.DayCalendarDto;
import com.example.diaryspring.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DayCalendarServiceImpl implements DayCalendarService {

    private final DayCalendarRepo dayCalendarRepo;
    private final UserService userService;

    @Override
    public List<DayCalendar> findAllByUserId(Integer user_id) {
        List<DayCalendar> dayCalendar = dayCalendarRepo.findAllByUserId(user_id);
        return dayCalendar;
    }

    @Override
    public DayCalendar updateCalendar(DayCalendar dayCalendar) {
        return dayCalendarRepo.save(dayCalendar);
    }

    @Override
    public void deleteCalendar(Integer id) {
        dayCalendarRepo.deleteById(id);
    }

    @Override
    public DayCalendar addCalendar(DayCalendarDto dayCalendarDto) {
        DayCalendar dayCalendar = dayCalendarDto.getDayCalendar();
        dayCalendar.setUser(userService.findByid(dayCalendarDto.getUser_id()));
        return dayCalendarRepo.save(dayCalendar);
    }

    @Override
    public List<DayCalendar> calendarList() {
        return dayCalendarRepo.findAll();
    }
}
