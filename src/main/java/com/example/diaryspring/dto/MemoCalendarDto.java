package com.example.diaryspring.dto;


import com.example.diaryspring.memocalendar.MemoCalendar;
import lombok.Data;

@Data
public class MemoCalendarDto {
    private String memo_username,memo_date, memo_title, memo_location, memo_description;
    Integer user_id;
}
