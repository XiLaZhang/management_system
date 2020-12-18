package io.renren.modules.meeting.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import cn.hutool.core.date.DateUtil;
import io.renren.common.utils.DateUtils;
import io.renren.modules.meeting.entity.MeetingEntity;
import io.renren.modules.meeting.service.MeetingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-12-11 17:31:56
 */
@Api(tags="会议对象")
@RestController
@RequestMapping("meeting/meeting")
public class MeetingController {
    @Autowired
    private MeetingService meetingService;

    /**
     * 列表
     */
    @ApiOperation("查询所有")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    @RequiresPermissions("meeting:meeting:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = meetingService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 小程序查询所有
     */
    @ApiOperation("小程序查询所有")
    @RequestMapping(value = "/applet/list", method = RequestMethod.GET)
    public R appletList(@RequestParam Map<String, Object> params){
        PageUtils page = meetingService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("按ID获取信息")
    @RequestMapping(value = "/info/{meetingId}", method = RequestMethod.GET)
    @RequiresPermissions("meeting:meeting:info")
    public R info(@PathVariable("meetingId") Long meetingId){
		MeetingEntity meeting = meetingService.getById(meetingId);

        return R.ok().put("meeting", meeting);
    }

    /**
     * 小程序信息查询
     */
    @ApiOperation("小程序按ID获取信息")
    @RequestMapping(value = "/applet/info/{meetingId}", method = RequestMethod.GET)
    public R appletInfo(@PathVariable Long meetingId){
        MeetingEntity meeting = meetingService.getById(meetingId);

        return R.ok().put("meeting", meeting);

    }

    /**
     * 保存
     */
    @ApiOperation("新增会议")
    @RequestMapping(value="/save", method = RequestMethod.POST)
    @RequiresPermissions("meeting:meeting:save")
    public R save(@RequestBody MeetingEntity meeting) {

        meetingService.save(meeting);

        return R.ok();
    }

    /**
     * 小程序新增会议
     */
    @ApiOperation("小程序新增会议")
    @RequestMapping(value="/applet/save", method = RequestMethod.POST)
    public R appletSave(@RequestBody MeetingEntity meeting){
        meetingService.save(meeting);

        return R.ok();
    }

    /**
     * 修改
     */
    @ApiOperation("修改会议")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @RequiresPermissions("meeting:meeting:update")
    public R update(@RequestBody MeetingEntity meeting){
		meetingService.updateById(meeting);

        return R.ok();
    }

    /**
     * 小程序修改会议
     */
    @ApiOperation("小程序修改会议")
    @RequestMapping(value = "/applet/update", method = RequestMethod.POST)
    public R appletUpdate(@RequestBody MeetingEntity meeting){
        meetingService.updateById(meeting);

        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation("删除会议")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @RequiresPermissions("meeting:meeting:delete")
    public R delete(@RequestBody Long[] meetingIds){
		meetingService.removeByIds(Arrays.asList(meetingIds));

        return R.ok();
    }

    /**
     * 小程序删除会议
     */
    @ApiOperation("小程序删除会议")
    @RequestMapping(value = "/applet/delete", method = RequestMethod.POST)
    public R appletDelete(@RequestBody Long meetingId){
        boolean res = meetingService.removeById(meetingId);
        if(res == false){
            return R.error("会议对象不存在");
        }

        return R.ok();
    }

}
