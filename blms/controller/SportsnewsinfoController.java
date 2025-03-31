package com.ysj.blms.controller;

import com.github.pagehelper.PageInfo;
import com.ysj.blms.domain.Sportsnews;
import com.ysj.blms.services.SportsnewsServices;
import com.ysj.blms.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sportsnews")
public class SportsnewsinfoController {

        @Autowired
        SportsnewsServices sportsnewsServices;

        //分页带条件查询
        @PostMapping("/page")
        public ResultVo page(@RequestBody Sportsnews sportsnews, @RequestParam(defaultValue = "1")Integer pageNum){
            PageInfo pageInfo= sportsnewsServices.getPage(sportsnews, pageNum);
            return ResultVo.success("",pageInfo);
        }
}
