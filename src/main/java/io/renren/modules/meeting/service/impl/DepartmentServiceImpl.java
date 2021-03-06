package io.renren.modules.meeting.service.impl;

import io.renren.common.utils.Query;
import io.renren.modules.meeting.dao.DepartmentDao;
import io.renren.modules.meeting.entity.DepartmentEntity;
import io.renren.modules.meeting.entity.RoomEntity;
import io.renren.modules.meeting.service.DepartmentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;


@Service("departmentService")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentDao, DepartmentEntity> implements DepartmentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<DepartmentEntity> page = this.page(
//                new Query<DepartmentEntity>().getPage(params),
//                new QueryWrapper<DepartmentEntity>()
//        );
        String depName = (String)params.get("depName");
        QueryWrapper<DepartmentEntity> depName1=null;
        if (StringUtils.isBlank(depName)){
            depName1 = new QueryWrapper<DepartmentEntity>();
        }else{
            depName1 = new QueryWrapper<DepartmentEntity>().like("dep_name", depName);

        }
        IPage<DepartmentEntity> page = this.page(
                new Query<DepartmentEntity>().getPage(params),
                depName1
        );
        return new PageUtils(page);
    }

}