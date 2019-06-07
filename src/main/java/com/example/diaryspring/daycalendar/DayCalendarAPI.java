package com.example.diaryspring.daycalendar;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/daycalendar")
@RequiredArgsConstructor
@Slf4j
public class DayCalendarAPI {
    private final DayCalendarRepo dayCalendarRepo;

    @PostMapping(path = "/add",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity add(@RequestBody DayCalendar dayCalendar) {
        return ResponseEntity.ok(dayCalendarRepo.save(dayCalendar));
    }

    @GetMapping("/list")
    public ResponseEntity<List<DayCalendar>> list() {
        return ResponseEntity.ok(dayCalendarRepo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DayCalendar> findById(@PathVariable Integer id) {
        Optional<DayCalendar> stock = dayCalendarRepo.findById(id);
        if (!stock.isPresent()) {
            log.error("ID" +id+"is not exist");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(stock.get());
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
