package io.renren.modules.meeting.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.meeting.entity.RoomEntity;
import io.renren.modules.meeting.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "会议室接口")
@RestController
@RequestMapping("meeting/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("meeting:room:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = roomService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 小程序查询所有
     */
    @ApiOperation("小程序查询所有")
    @RequestMapping("/applet/list")
    public R applteList(@RequestParam Map<String, Object> params){
        PageUtils page = roomService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{roomId}")
    @RequiresPermissions("meeting:room:info")
    public R info(@PathVariable("roomId") Long roomId){
		RoomEntity room = roomService.getById(roomId);

        return R.ok().put("room", room);
    }

    /**
     * 按ID查询信息
     */
    @ApiOperation("小程序按ID查询")
    @RequestMapping("/info/{roomId")
    public R appletInfo(@PathVariable Long roomId){
        RoomEntity room = roomService.getById(roomId);

        return R.ok().put("room", room);
    }

    /**
     * 查询出当前可用的会议室
     */
//    @ApiOperation("小程序当前可用会议室")
//    @RequestMapping("/applet/roomlist")
//    public R roomList(){
//
//    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("meeting:room:save")
    public R save(@RequestBody RoomEntity room){
		roomService.save(room);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("meeting:room:update")
    public R update(@RequestBody RoomEntity room){
		roomService.updateById(room);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("meeting:room:delete")
    public R delete(@RequestBody Long[] roomIds){
		roomService.removeByIds(Arrays.asList(roomIds));

        return R.ok();
    }

}
