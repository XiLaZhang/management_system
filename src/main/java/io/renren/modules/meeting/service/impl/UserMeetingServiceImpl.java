package io.renren.modules.meeting.service.impl;

import io.renren.modules.meeting.dao.UserMeetingDao;
import io.renren.modules.meeting.entity.UserMeetingEntity;
import io.renren.modules.meeting.service.UserMeetingService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;


@Service("userMeetingService")
public class UserMeetingServiceImpl extends ServiceImpl<UserMeetingDao, UserMeetingEntity> implements UserMeetingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserMeetingEntity> page = this.page(
                new Query<UserMeetingEntity>().getPage(params),
                new QueryWrapper<UserMeetingEntity>()
        );

        return new PageUtils(page);
    }

}