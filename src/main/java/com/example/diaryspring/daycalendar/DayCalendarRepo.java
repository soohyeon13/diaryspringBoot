package com.example.diaryspring.daycalendar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayCalendarRepo extends JpaRepository<DayCalendar,Integer> {
}
