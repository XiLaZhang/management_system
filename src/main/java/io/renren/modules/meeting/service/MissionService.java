package io.renren.modules.meeting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.meeting.entity.MissionEntity;
import io.renren.common.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author zrd
 * @date 2020-12-11 17:31:56
 */
public interface MissionService extends IService<MissionEntity> {

    PageUtils queryPage(Map<String, Object> params);


}

