package io.renren.modules.meeting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.meeting.entity.UserMeetingEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-12-11 17:31:56
 */
public interface UserMeetingService extends IService<UserMeetingEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 添加用户会议信息
     */
    void saveUserMeeting(Long meetingId,List<Long>userId, Long createUserId);

    /**
     * 查询会议创建人的所有会议
     */
    List<Long> queryCreateMeetingList(Long userId);

    /**
     * 按会议ID以及参会状态查询参会人员
     */
    List<Long> queryUserListByMeetingId(Long meetingId);
}

