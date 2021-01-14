package io.renren.modules.meeting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.meeting.dao.MeetingRoomDao;
import io.renren.modules.meeting.entity.MeetingRoomEntity;
import io.renren.modules.meeting.service.MeetingRoomService;
import org.springframework.stereotype.Service;


@Service("meetingRoomService")
public class MeetingRoomServiceImpl extends ServiceImpl<MeetingRoomDao, MeetingRoomEntity> implements MeetingRoomService {

    @Override
    public Long queryRoomByMeeting(Long meetingId) {
        return baseMapper.queryRoomByMeeting(meetingId);
    }



}
