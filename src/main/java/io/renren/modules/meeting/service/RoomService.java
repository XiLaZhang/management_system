package io.renren.modules.meeting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.meeting.entity.RoomEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-12-11 17:31:56
 */
public interface RoomService extends IService<RoomEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据会议室ID查询会议室名
     * @param roomId
     * @return
     */
    String queryNameById(Long roomId);
}

