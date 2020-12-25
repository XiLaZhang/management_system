package io.renren.modules.meeting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.meeting.entity.MeetingEntity;
import io.renren.common.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author zrd
 * @date 2020-12-11 17:31:56
 */
public interface MeetingService extends IService<MeetingEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存会议对象
     * @param meetingEntity
     */
    void saveMeeting(MeetingEntity meetingEntity,  Long createUserId);

    /**
     * 按验证码查询会议
     */
    MeetingEntity queryMeetingByCode(String code);
}

