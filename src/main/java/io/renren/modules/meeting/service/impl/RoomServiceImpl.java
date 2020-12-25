package io.renren.modules.meeting.service.impl;

import io.renren.common.utils.Query;
import io.renren.modules.meeting.dao.RoomDao;
import io.renren.modules.meeting.entity.RoomEntity;
import io.renren.modules.meeting.service.RoomService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;


@Service("roomService")
public class RoomServiceImpl extends ServiceImpl<RoomDao, RoomEntity> implements RoomService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RoomEntity> page = this.page(
                new Query<RoomEntity>().getPage(params),
                new QueryWrapper<RoomEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public String queryNameById(Long roomId) {
        return baseMapper.queryNameById(roomId);
    }
}