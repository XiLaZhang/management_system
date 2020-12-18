package io.renren.modules.meeting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.meeting.entity.SignInEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-12-11 17:31:56
 */
public interface SignInService extends IService<SignInEntity> {

    PageUtils queryPage(Map<String, Object> params);

    //验证code
    Boolean isSignIn(String code);
}

