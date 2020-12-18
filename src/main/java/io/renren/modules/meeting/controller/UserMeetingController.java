package io.renren.modules.meeting.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.meeting.entity.UserMeetingEntity;
import io.renren.modules.meeting.service.UserMeetingService;
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
@RequestMapping("meeting/usermeeting")
public class UserMeetingController {
    @Autowired
    private UserMeetingService userMeetingService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("meeting:usermeeting:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userMeetingService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("meeting:usermeeting:info")
    public R info(@PathVariable("id") Long id){
		UserMeetingEntity userMeeting = userMeetingService.getById(id);

        return R.ok().put("userMeeting", userMeeting);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("meeting:usermeeting:save")
    public R save(@RequestBody UserMeetingEntity userMeeting){
		userMeetingService.save(userMeeting);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("meeting:usermeeting:update")
    public R update(@RequestBody UserMeetingEntity userMeeting){
		userMeetingService.updateById(userMeeting);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("meeting:usermeeting:delete")
    public R delete(@RequestBody Long[] ids){
		userMeetingService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
