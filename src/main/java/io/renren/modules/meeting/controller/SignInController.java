package io.renren.modules.meeting.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.meeting.entity.SignInEntity;
import io.renren.modules.meeting.service.SignInService;
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
@RequestMapping("meeting/signin")
public class SignInController {
    @Autowired
    private SignInService signInService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("meeting:signin:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = signInService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("meeting:signin:info")
    public R info(@PathVariable("id") Long id){
		SignInEntity signIn = signInService.getById(id);

        return R.ok().put("signIn", signIn);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("meeting:signin:save")
    public R save(@RequestBody SignInEntity signIn){
		signInService.save(signIn);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("meeting:signin:update")
    public R update(@RequestBody SignInEntity signIn){
		signInService.updateById(signIn);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("meeting:signin:delete")
    public R delete(@RequestBody Long[] ids){
		signInService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
