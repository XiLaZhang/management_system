package io.renren.modules.meeting.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.meeting.entity.SignMeetingEntity;
import io.renren.modules.meeting.service.SignMeetingService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-12-11 17:31:56
 */
@RestController
@RequestMapping("meeting/signmeeting")
public class SignMeetingController {
    @Autowired
    private SignMeetingService signMeetingService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("meeting:signmeeting:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = signMeetingService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("meeting:signmeeting:info")
    public R info(@PathVariable("id") Long id){
		SignMeetingEntity signMeeting = signMeetingService.getById(id);

        return R.ok().put("signMeeting", signMeeting);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("meeting:signmeeting:save")
    public R save(@RequestBody SignMeetingEntity signMeeting){
		signMeetingService.save(signMeeting);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("meeting:signmeeting:update")
    public R update(@RequestBody SignMeetingEntity signMeeting){
		signMeetingService.updateById(signMeeting);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("meeting:signmeeting:delete")
    public R delete(@RequestBody Long[] ids){
		signMeetingService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
