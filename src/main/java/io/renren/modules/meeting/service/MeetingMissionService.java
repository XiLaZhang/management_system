package io.renren.modules.meeting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.meeting.entity.MeetingMissionEntity;

/**
 * 会议对象-会议任务
 *
 * @author zrd
 * @date 2020-12-23
 */
public interface MeetingMissionService extends IService<MeetingMissionEntity> {

    /**
     * 添加会议对象及会议任务
     */
    void saveMeetingMission(Long meetingId, Long missionId);
}
