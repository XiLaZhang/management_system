package io.renren.modules.meeting.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.meeting.entity.MissionEntity;
import io.renren.modules.meeting.service.MissionService;
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
@RequestMapping("meeting/mission")
public class MissionController {
    @Autowired
    private MissionService missionService;

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
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("meeting:mission:info")
    public R info(@PathVariable("id") Long id){
		MissionEntity mission = missionService.getById(id);

        return R.ok().put("mission", mission);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("meeting:mission:save")
    public R save(@RequestBody MissionEntity mission){
		missionService.save(mission);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("meeting:mission:update")
    public R update(@RequestBody MissionEntity mission){
		missionService.updateById(mission);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("meeting:mission:delete")
    public R delete(@RequestBody Long[] ids){
		missionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
