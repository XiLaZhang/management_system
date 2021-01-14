package io.renren.modules.meeting.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.meeting.entity.NoteEntity;
import io.renren.modules.meeting.service.NoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * @author zrd
 * @date 2020-12-11 17:31:56
 */
@Api(tags = "笔记接口")
@RestController
@RequestMapping("meeting/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    /**
     * 小程序查询列表
     */
    @ApiOperation("小程序查询列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = noteService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 小程序按ID查询笔记信息
     */
    @ApiOperation("小程序按ID查询笔记信息")
    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public R info(@PathVariable("id") Long id){
		NoteEntity note = noteService.getById(id);

        return R.ok().put("note", note);
    }

    /**
     * 小程序保存笔记
     */
    @ApiOperation("小程序保存笔记")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public R save(@RequestBody NoteEntity note){
		noteService.save(note);

        return R.ok();
    }

    /**
     * 小程序修改笔记
     */
    @ApiOperation("小程序修改笔记")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public R update(@RequestBody NoteEntity note){
		noteService.updateById(note);

        return R.ok();
    }

    /**
     * 小程序删除笔记
     */
    @ApiOperation("小程序删除笔记")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public R delete(@RequestBody Long[] ids){
		noteService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
