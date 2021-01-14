package io.renren.modules.meeting.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.meeting.entity.UserMeetingEntity;
import io.renren.modules.meeting.service.UserMeetingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * @author zrd
 * @date 2020-12-11
 */
@Api(tags = "用户会议接口")
@RestController
@RequestMapping("meeting/usermeeting")
public class UserMeetingController {
    @Autowired
    private UserMeetingService userMeetingService;

//    /**
//     * 小程序查询会议成员列表
//     */
//    @RequestMapping("/applet/list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = userMeetingService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }


//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
//    @RequiresPermissions("meeting:usermeeting:info")
//    public R info(@PathVariable("id") Long id){
//		UserMeetingEntity userMeeting = userMeetingService.getById(id);
//
//        return R.ok().put("userMeeting", userMeeting);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//    @RequiresPermissions("meeting:usermeeting:save")
//    public R save(@RequestBody UserMeetingEntity userMeeting){
//		userMeetingService.save(userMeeting);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    @RequiresPermissions("meeting:usermeeting:update")
//    public R update(@RequestBody UserMeetingEntity userMeeting){
//		userMeetingService.updateById(userMeeting);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    @RequiresPermissions("meeting:usermeeting:delete")
//    public R delete(@RequestBody Long[] ids){
//		userMeetingService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

    /**
     * 小程序查询会议成员列表
     */
    @ApiOperation("小程序查询会议成员列表")
    @RequestMapping(value = "/applet/list", method = RequestMethod.GET)
    public R appletUserMeetingList(@RequestParam Long meetingId){
        List<Long> userIdList = userMeetingService.queryUserListByMeetingId(meetingId);

        return R.ok().put("userIdList", userIdList);
    }


}
