package io.renren.modules.meeting.service.impl;

import io.renren.common.utils.Query;
import io.renren.modules.meeting.entity.MissionEntity;
import io.renren.modules.meeting.dao.MissionDao;
import io.renren.modules.meeting.service.MissionService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;


@Service("missionService")
public class MissionServiceImpl extends ServiceImpl<MissionDao, MissionEntity> implements MissionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MissionEntity> page = this.page(
                new Query<MissionEntity>().getPage(params),
                new QueryWrapper<MissionEntity>()
        );

        return new PageUtils(page);
    }



}