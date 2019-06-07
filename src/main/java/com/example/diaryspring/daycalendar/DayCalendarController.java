package com.example.diaryspring.daycalendar;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
//
//@RestController
//@RequestMapping("/daycalendar")
//@RequiredArgsConstructor
@Controller
public class DayCalendarController {

    @GetMapping("/")
    public String list() {
        return "daycalendars";
    }
//    private final DayCalendarRepo dayCalendarRepo;
//
//    @PostMapping(path = "/add",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public DayCalendar add(@RequestBody DayCalendar dayCalendar) {
//        DayCalendar dayCalendarData = dayCalendarRepo.save(dayCalendar);
//        return dayCalendar;
//    }
//
//    @GetMapping("/list")
//    public List<DayCalendar> list() {
//        List<DayCalendar> dayList = dayCalendarRepo.findAll();
//        return dayList;
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String delete(@PathVariable int id) {
//        System.out.println("id=" + id);
//        dayCalendarRepo.deleteById(id);
//        return "redirect:/daycalendar/list";
//    }
//    @PutMapping("/{id}")
//    public List<DayCalendar> update(@PathVariable int id , @Valid @RequestBody DayCalendar dayCalendar) {
//        return null;
//
//    }
}
