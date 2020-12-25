package io.renren.modules.meeting.service.impl;

import io.renren.common.utils.Query;
import io.renren.modules.meeting.entity.MeetingEntity;
import io.renren.modules.meeting.service.UserMeetingService;
import io.renren.modules.meeting.dao.MeetingDao;
import io.renren.modules.meeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import org.springframework.transaction.annotation.Transactional;


@Service("meetingService")
public class MeetingServiceImpl extends ServiceImpl<MeetingDao, MeetingEntity> implements MeetingService {

    @Autowired
    private UserMeetingService userMeetingService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MeetingEntity> page = this.page(
                new Query<MeetingEntity>().getPage(params),
                new QueryWrapper<MeetingEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional
    public void saveMeeting(MeetingEntity meetingEntity, Long createUserId) {
        meetingEntity.setCreatetime(new Date());
        meetingEntity.setSignCode(generateCode());
        this.save(meetingEntity);

        //保存用户和会议的关系
        userMeetingService.saveUserMeeting(meetingEntity.getMeetingId(), meetingEntity.getUserIdList(), createUserId);
    }

    @Override
    public MeetingEntity queryMeetingByCode(String code) {
        if(code == null || code.length() == 0){
            return null;
        }
        Integer meetingId = baseMapper.queryMeetingByCode(code);
        MeetingEntity entity = baseMapper.selectById(meetingId);
        return entity;
    }

    /**
     * 生成验证码
     */
    public static String generateCode() {
        String[] beforeShuffle = new String[] { "1", "2", "3", "4", "5", "6", "7",
                "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        List list = Arrays.asList(beforeShuffle);
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String afterShuffle = sb.toString();
        String result = afterShuffle.substring(5, 9);

        return result;
    }
}