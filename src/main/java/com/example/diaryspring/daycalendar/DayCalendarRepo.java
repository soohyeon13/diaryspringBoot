package com.example.diaryspring.daycalendar;

import com.example.diaryspring.user.User;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DayCalendarRepo extends JpaRepository<DayCalendar,Integer> {
//    public List<User> findAllByUserId(Integer user_id);
}
