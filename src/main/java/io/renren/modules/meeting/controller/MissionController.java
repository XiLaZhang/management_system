package io.renren.modules.meeting.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.meeting.entity.MissionEntity;
import io.renren.modules.meeting.service.MeetingMissionService;
import io.renren.modules.meeting.service.MissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * @author zrd
 * @date 2020-12-11 17:31:56
 */
@Api(tags = "会议任务接口")
@RestController
@RequestMapping("meeting/mission")
public class MissionController {
    @Autowired
    private MissionService missionService;
    @Autowired
    private MeetingMissionService meetingMissionService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("meeting:mission:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = missionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 小程序查询会议任务信息
     */
    @ApiOperation("小程序查询会议任务信息")
    @RequestMapping(value = "/applet/info/{id}", method = RequestMethod.GET)
    public R info(@PathVariable("id") Long id){
		MissionEntity mission = missionService.getById(id);

        return R.ok().put("mission", mission);
    }

    /**
     * 小程序新增会议任务
     */
    @ApiOperation("小程序新增会议任务")
    @RequestMapping(value = "/applet/save", method = RequestMethod.POST)
    public R save(@RequestBody MissionEntity mission, Long meetingId){
		missionService.save(mission);
        meetingMissionService.saveMeetingMission(mission.getMissionId(), meetingId);

        return R.ok();
    }

    /**
     * 小程序修改会议任务
     */
    @ApiOperation("小程序修改会议任务")
    @RequestMapping(value = "/applet/update", method = RequestMethod.POST)
    public R update(@RequestBody MissionEntity mission){
		missionService.updateById(mission);

        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation("小程序删除会议任务")
    @RequestMapping(value = "/applet/delete", method = RequestMethod.POST)
    public R delete(@RequestBody Long[] ids){
		missionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
