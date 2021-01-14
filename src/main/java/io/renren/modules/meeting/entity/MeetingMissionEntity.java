package io.renren.modules.meeting.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 会议对象-会议任务表
 *
 * @author zrd
 * @date 2020-12-23
 */
@Data
@TableName("meeting_mission")
public class MeetingMissionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    private Long id;
    /**
     * 会议对象ID
     */
    private Long meeting_id;
    /**
     * 会议任务ID
     */
    private Long mission_id;
}
