package io.renren.modules.meeting.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.meeting.entity.MeetingEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author zrd
 * @date 2020-12-11 17:31:56
 */
@Mapper
public interface MeetingDao extends BaseMapper<MeetingEntity> {

    /**
     * 按验证码查询会议对象
     * @param code
     * @return
     */
    Integer queryMeetingByCode(String code);
}
