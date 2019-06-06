package com.example.diaryspring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayCalendarRepo extends JpaRepository<DayCalendar,Integer> {
}
