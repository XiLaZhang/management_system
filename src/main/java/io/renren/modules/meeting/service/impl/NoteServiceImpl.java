package io.renren.modules.meeting.service.impl;

import io.renren.common.utils.Query;
import io.renren.modules.meeting.dao.NoteDao;
import io.renren.modules.meeting.entity.NoteEntity;
import io.renren.modules.meeting.entity.RoomEntity;
import io.renren.modules.meeting.service.NoteService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;


@Service("noteService")
public class NoteServiceImpl extends ServiceImpl<NoteDao, NoteEntity> implements NoteService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<NoteEntity> page = this.page(
//                new Query<NoteEntity>().getPage(params),
//                new QueryWrapper<NoteEntity>()
//        );
        String mains = (String)params.get("mains");
        QueryWrapper<NoteEntity> mains1=null;
        if (StringUtils.isBlank(mains)){
            mains1 = new QueryWrapper<NoteEntity>();
        }else{
            mains1 = new QueryWrapper<NoteEntity>().like("mains", mains);

        }
        IPage<NoteEntity> page = this.page(
                new Query<NoteEntity>().getPage(params),
                mains1
        );
        return new PageUtils(page);
    }

}