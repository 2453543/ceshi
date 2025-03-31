package com.ysj.blms.controller;

import com.github.pagehelper.PageInfo;
import com.ysj.blms.domain.Announcements;
import com.ysj.blms.services.AnnouncementsServices;
import com.ysj.blms.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/announcements")
public class AnnouncementsinfoController {
        @Autowired
        AnnouncementsServices announcementsServices;

        //分页带条件查询
        @PostMapping("/page")
        public ResultVo page(@RequestBody Announcements announcements, @RequestParam(defaultValue = "1")Integer pageNum){
            PageInfo pageInfo= announcementsServices.getPage(announcements, pageNum);
            return ResultVo.success("",pageInfo);
        }
    }
