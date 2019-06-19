package com.example.diaryspring.memocalendar;

import com.example.diaryspring.dto.MemoCalendarDto;

import java.util.List;

public interface MemoCalendarService {
    List<MemoCalendar> findAllByUserId(Integer memo_user_id);

    MemoCalendar updateMemoCalendar(MemoCalendar memoCalendar);

    void deleteMemoCalendar(Integer id);

    MemoCalendar addMemoCalendar(MemoCalendarDto memoCalendarDto);

    List<MemoCalendar> memoCalendarList();
}
