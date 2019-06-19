package com.example.diaryspring.memocalendar;

import com.example.diaryspring.dto.MemoCalendarDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memocalendar")
@Slf4j
public class MemoCalendarController {
    private final MemoCalendarService memoCalendarService;

    @Autowired
    public MemoCalendarController(MemoCalendarService memoCalendarService) {
        this.memoCalendarService = memoCalendarService;
    }

    @PostMapping(value = "/add",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MemoCalendar addMemoCalendar (@RequestBody MemoCalendarDto memoCalendarDto) {
        return memoCalendarService.addMemoCalendar(memoCalendarDto);
    }

    @GetMapping(value = "/list")
    public List<MemoCalendar> memoList() {
        List<MemoCalendar> memoList = memoCalendarService.memoCalendarList();
        return memoList;
    }
    @GetMapping(value = "{memo_user_id}")
    public List<MemoCalendar> findAllByUserId(@PathVariable Integer memo_user_id) {
        List<MemoCalendar> memoCalendars = memoCalendarService.findAllByUserId(memo_user_id);
        return memoCalendars;
    }

    @PutMapping(value = "/update")
    public MemoCalendar updatememo(MemoCalendar memoCalendar) {
        return memoCalendarService.updateMemoCalendar(memoCalendar);
    }

    @DeleteMapping
    public void deleteMemoCalendar(@RequestHeader Integer id) {
        memoCalendarService.deleteMemoCalendar(id);
    }
}
