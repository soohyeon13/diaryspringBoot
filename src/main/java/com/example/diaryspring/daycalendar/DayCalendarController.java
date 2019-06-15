package com.example.diaryspring.daycalendar;


import com.example.diaryspring.payload.DayCalendarPayLoad;
import com.example.diaryspring.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/daycalendar")
@RequiredArgsConstructor
@Slf4j
public class DayCalendarController {
    private final DayCalendarRepo dayCalendarRepo;
    private final UserService userService;

    @PostMapping(path = "/add",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity add(@RequestBody DayCalendarPayLoad dayCalendarPayLoad) {
        DayCalendar dayCalendar = dayCalendarPayLoad.getDayCalendar();
        dayCalendar.setUser(userService.findByid(dayCalendarPayLoad.getUser_id()));
        return ResponseEntity.ok(dayCalendarRepo.save(dayCalendar));
    }

    @GetMapping("/list")
    public ResponseEntity<List<DayCalendar>> list() {
        return ResponseEntity.ok(dayCalendarRepo.findAll());
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<List<DayCalendar>> findAllByUserId(@PathVariable Integer user_id) {
        List<DayCalendar> dayCalendarList = dayCalendarRepo.findAllByUserId(user_id);
        if (dayCalendarList.isEmpty()) {
            log.error("ID" +user_id+"is not exist");
            ResponseEntity.badRequest().build();
        }
       return ResponseEntity.ok(dayCalendarList);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        if (!dayCalendarRepo.findById(id).isPresent()) {
            log.error("ID" +id+"is not exist");
            ResponseEntity.badRequest().build();
        }
        dayCalendarRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<DayCalendar> update(@PathVariable Integer id , @Valid @RequestBody DayCalendar dayCalendar) {
        if (!dayCalendarRepo.findById(id).isPresent()) {
            log.error("ID" +id+"is not exist");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(dayCalendarRepo.save(dayCalendar));
    }
}
