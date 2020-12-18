package io.renren.modules.meeting.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.meeting.entity.NoteEntity;
import io.renren.modules.meeting.service.NoteService;
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
@RequestMapping("meeting/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("meeting:note:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = noteService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("meeting:note:info")
    public R info(@PathVariable("id") Long id){
		NoteEntity note = noteService.getById(id);

        return R.ok().put("note", note);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("meeting:note:save")
    public R save(@RequestBody NoteEntity note){
		noteService.save(note);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("meeting:note:update")
    public R update(@RequestBody NoteEntity note){
		noteService.updateById(note);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("meeting:note:delete")
    public R delete(@RequestBody Long[] ids){
		noteService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
