package io.renren.modules.meeting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.meeting.entity.MeetingRoomEntity;

public interface MeetingRoomService extends IService<MeetingRoomEntity> {

    /**
     * 根据会议ID查询会议室
     */
    Long queryRoomByMeeting(Long meetingId);
}
