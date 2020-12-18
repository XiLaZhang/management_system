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
@TableName("mission")
public class MissionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Long id;
	/**
	 * 会议主题
	 */
	private String topic;
	/**
	 * 会议大纲
	 */
	private String outline;
	/**
	 * 详细内容安排
	 */
	private String task;
	/**
	 * 会议确定条款
	 */
	private String clause;
	/**
	 * 落实步骤
	 */
	private String steps;
	/**
	 * 限时完成时间
	 */
	private Date endtime;

}
