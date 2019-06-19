package com.example.diaryspring.memocalendar;


import com.example.diaryspring.dto.MemoCalendarDto;
import com.example.diaryspring.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoCalendarServiceImpl implements MemoCalendarService {

    private final MemoCalendarRepo memoCalendarRepo;
    private final UserService userService;

    @Override
    public List<MemoCalendar> findAllByUserId(Integer memo_user_id) {
        List<MemoCalendar> memoCalendars = memoCalendarRepo.findAllByUserId(memo_user_id);
        return memoCalendars;
    }

    @Override
    public MemoCalendar updateMemoCalendar(MemoCalendar memoCalendar) {
        return memoCalendarRepo.save(memoCalendar);
    }

    @Override
    public void deleteMemoCalendar(Integer id) {
        memoCalendarRepo.deleteById(id);
    }

    @Override
    public MemoCalendar addMemoCalendar(MemoCalendarDto memoCalendarDto) {
        MemoCalendar memoCalendar =memoCalendarDto.getMemoCalendar();
        memoCalendar.setUser(userService.findByid(memoCalendarDto.getMemo_user_id()));
        return memoCalendarRepo.save(memoCalendar);
    }

    @Override
    public List<MemoCalendar> memoCalendarList() {
        return memoCalendarRepo.findAll();
    }
}


