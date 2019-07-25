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
        MemoCalendar memoCalendar = MemoCalendar.builder()
                .memo_description(memoCalendarDto.getMemo_description())
                .memo_location(memoCalendarDto.getMemo_location())
                .memo_title(memoCalendarDto.getMemo_title())
                .memo_date(memoCalendarDto.getMemo_date())
                .user(userService.findByid(memoCalendarDto.getUser_id()))
                .build();
//        MemoCalendar memoCalendar =memoCalendarDto.getMemoCalendar();
//        memoCalendar.setUser(userService.findByid(memoCalendarDto.getMemo_user_id()));
//        return memoCalendarRepo.save(memoCalendar);
        return memoCalendarRepo.save(memoCalendar);
    }

    @Override
    public List<MemoCalendar> memoCalendarList() {
        return memoCalendarRepo.findAll();
    }
}


