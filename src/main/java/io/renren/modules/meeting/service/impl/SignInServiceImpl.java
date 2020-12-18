package io.renren.modules.meeting.service.impl;

import io.renren.modules.meeting.dao.SignInDao;
import io.renren.modules.meeting.entity.SignInEntity;
import io.renren.modules.meeting.service.SignInService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;



@Service("signInService")
public class SignInServiceImpl extends ServiceImpl<SignInDao, SignInEntity> implements SignInService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SignInEntity> page = this.page(
                new Query<SignInEntity>().getPage(params),
                new QueryWrapper<SignInEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public Boolean isSignIn(String code) {
//        String date =
        return null;
    }

    //生成验证码
    public String generateCode(){
        String code = String.valueOf((int)((Math.random()*9+1)*1000));
        return code;
    }
}