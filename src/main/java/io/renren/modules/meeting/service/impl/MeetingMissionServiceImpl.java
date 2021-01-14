package io.renren.modules.meeting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.meeting.dao.MeetingMissionDao;
import io.renren.modules.meeting.entity.MeetingMissionEntity;
import io.renren.modules.meeting.service.MeetingMissionService;
import org.springframework.stereotype.Service;

@Service
public class MeetingMissionServiceImpl extends ServiceImpl<MeetingMissionDao, MeetingMissionEntity> implements MeetingMissionService {

    @Override
    public void saveMeetingMission(Long meetingId, Long missionId) {
        MeetingMissionEntity meetingMissionEntity = new MeetingMissionEntity();
        meetingMissionEntity.setMeeting_id(meetingId);
        meetingMissionEntity.setMission_id(missionId);

        this.save(meetingMissionEntity);
    }
}
