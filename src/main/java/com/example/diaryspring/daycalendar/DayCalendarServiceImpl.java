package com.example.diaryspring.daycalendar;

import com.example.diaryspring.payload.DayCalendarPayLoad;
import com.example.diaryspring.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public DayCalendar addCalendar(DayCalendarPayLoad dayCalendarPayLoad) {
        DayCalendar dayCalendar = dayCalendarPayLoad.getDayCalendar();
        dayCalendar.setUser(userService.findByid(dayCalendarPayLoad.getUser_id()));
        return dayCalendarRepo.save(dayCalendar);
    }

    @Override
    public List<DayCalendar> calendarList() {
        return dayCalendarRepo.findAll();
    }
}
