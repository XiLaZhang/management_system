package io.renren.modules.meeting.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.meeting.entity.MeetingMissionEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author zrd
 * @date 2020-12-23
 */
@Mapper
public interface MeetingMissionDao extends BaseMapper<MeetingMissionEntity> {

    /**
     * 查询会议任务
     * @param meetingId
     * @return
     */
    Long queryMissionIdByMeeting(Long meetingId);
}
