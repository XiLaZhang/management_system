package io.renren.modules.meeting.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.meeting.entity.MeetingRoomEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MeetingRoomDao extends BaseMapper<MeetingRoomEntity> {

    /**
     * 按会议查询会议室ID
     */
    Long queryRoomByMeeting(Long meetingId);

}
