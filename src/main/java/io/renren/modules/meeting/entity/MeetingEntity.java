package io.renren.modules.meeting.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * 会议对象表
 *
 * @author zrd
 * @date 2020-12-11 17:31:56
 */
@Data
@TableName("meeting")
public class MeetingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 会议ID
	 */
	@TableId
	private Long meetingId;
	/**
	 * 会议名
	 */
	private String meetingname;
	/**
	 * 发起人
	 */
	private String initiator;
	/**
	 * 会议主题
	 */
	private String topic;
	/**
	 * 资料
	 */
	private String material;
	/**
	 * 开始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date starttime;
	/**
	 * 结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endtime;
	/**
	 * 会议状态，0正常，1结束
	 */
	private Integer meetingStatus;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createtime;
	/**
	 * 签到码
	 */
	@TableField(exist = false)
	private String signCode;
	/**
	 * 会议室ID
	 */
	@TableField(exist = false)
	private Long roomId;
	/**
	 * 用户列表
	 */
	@TableField(exist = false)
	private List<Long> userIdList;
	/**
	 * 会议任务ID
	 */
	@TableField(exist = false)
	private Long missionId;
}
