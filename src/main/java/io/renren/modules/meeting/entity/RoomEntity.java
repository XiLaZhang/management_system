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
@TableName("room")
public class RoomEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 会议室ID
	 */
	@TableId
	private Long roomId;
	/**
	 * 会议室名称
	 */
	private String roomName;
	/**
	 * 地点
	 */
	private String place;
	/**
	 * 会议室容量
	 */
	private Integer capacity;
	/**
	 * 备注
	 */
	private String mark;
	/**
	 * 状态，0正常，1使用中，2停用
	 */
	private Integer state;

}
