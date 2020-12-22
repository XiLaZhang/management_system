package io.renren.modules.meeting.service.impl;

import io.renren.modules.meeting.dao.MeetingDao;
import io.renren.modules.meeting.entity.MeetingEntity;
import io.renren.modules.meeting.entity.UserMeetingEntity;
import io.renren.modules.meeting.service.MeetingService;
import io.renren.modules.meeting.service.UserMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.Date;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import org.springframework.transaction.annotation.Transactional;


@Service("meetingService")
public class MeetingServiceImpl extends ServiceImpl<MeetingDao, MeetingEntity> implements MeetingService {

    @Autowired
    private UserMeetingService userMeetingService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MeetingEntity> page = this.page(
                new Query<MeetingEntity>().getPage(params),
                new QueryWrapper<MeetingEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional
    public void saveMeeting(MeetingEntity meetingEntity, Long createUserId) {
        meetingEntity.setCreatetime(new Date());
        this.save(meetingEntity);

        //保存用户和会议的关系
        userMeetingService.saveUserMeeting(meetingEntity.getMeetingId(), meetingEntity.getUserIdList(), createUserId);
    }
}