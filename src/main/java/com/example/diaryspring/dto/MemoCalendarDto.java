package com.example.diaryspring.dto;


import com.example.diaryspring.memocalendar.MemoCalendar;
import lombok.Data;

@Data
public class MemoCalendarDto {
    MemoCalendar memoCalendar;
    Integer memo_user_id;
}
