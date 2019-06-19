package com.example.diaryspring.memocalendar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Max;
import java.util.List;

@Repository
public interface MemoCalendarRepo extends JpaRepository<MemoCalendar,Integer> {
    List<MemoCalendar> findAllByUserId(Integer memo_user_id);
}
