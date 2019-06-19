package com.example.diaryspring.memocalendar;

import com.example.diaryspring.dto.MemoCalendarDto;

import java.util.List;

public interface MemoCalendarService {
    List<MemoCalendar> findAllByUserId(Integer memo_user_id);

    MemoCalendar updateCalendar(MemoCalendar memoCalendar);

    void deleteCalendar(Integer id);

    MemoCalendar addCalendar(MemoCalendarDto memoCalendarDto);

    List<MemoCalendar> calendarList();
}
