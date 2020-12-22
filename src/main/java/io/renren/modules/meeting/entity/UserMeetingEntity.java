package io.renren.modules.meeting.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-12-11 17:31:56
 */
@Data
@TableName("user_meeting")
public class UserMeetingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Long id;
	/**
	 * 会议ID
	 */
	private Long meetingId;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 是否会议创建人，0是，1否
	 */
	private Integer createState;
	/**
	 * 参会状态，0参会，1缺席，2空闲
	 */
	private Integer joinState;

}
