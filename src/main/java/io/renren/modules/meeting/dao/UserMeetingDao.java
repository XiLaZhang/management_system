package io.renren.modules.meeting.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.meeting.entity.UserMeetingEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-12-11 17:31:56
 */
@Mapper
public interface UserMeetingDao extends BaseMapper<UserMeetingEntity> {

    /**
     * 查询会议创建人的所有会议
     */
    List<Long> queryCreateMeetingList(Long userId);

    /**
     * 按会议ID以及参会状态查询参会人员
     */
    List<Long> queryUserListByMeetingId(Long meetingId);

}
