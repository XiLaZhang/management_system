package io.renren.modules.meeting.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.meeting.entity.RoomEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-12-11 17:31:56
 */
@Mapper
public interface RoomDao extends BaseMapper<RoomEntity> {
	
}
