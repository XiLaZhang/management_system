package io.renren.modules.meeting.service.impl;

import io.renren.modules.meeting.dao.MeetingDao;
import io.renren.modules.meeting.entity.MeetingEntity;
import io.renren.modules.meeting.service.MeetingService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;


@Service("meetingService")
public class MeetingServiceImpl extends ServiceImpl<MeetingDao, MeetingEntity> implements MeetingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MeetingEntity> page = this.page(
                new Query<MeetingEntity>().getPage(params),
                new QueryWrapper<MeetingEntity>()
        );

        return new PageUtils(page);
    }

}