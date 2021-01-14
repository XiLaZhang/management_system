package io.renren.modules.meeting.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.meeting.entity.UserDeptEntity;
import io.renren.modules.meeting.service.UserDeptService;
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
@RequestMapping("meeting/userdept")
public class UserDeptController {
    @Autowired
    private UserDeptService userDeptService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("meeting:userdept:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userDeptService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("meeting:userdept:info")
    public R info(@PathVariable("id") Long id){
		UserDeptEntity userDept = userDeptService.getById(id);

        return R.ok().put("userDept", userDept);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("meeting:userdept:save")
    public R save(@RequestBody UserDeptEntity userDept){
		userDeptService.save(userDept);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("meeting:userdept:update")
    public R update(@RequestBody UserDeptEntity userDept){
		userDeptService.updateById(userDept);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("meeting:userdept:delete")
    public R delete(@RequestBody Long[] ids){
		userDeptService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
