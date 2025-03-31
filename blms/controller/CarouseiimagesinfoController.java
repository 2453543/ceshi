package com.ysj.blms.controller;

import com.github.pagehelper.PageInfo;
import com.ysj.blms.domain.Carouseiimages;
import com.ysj.blms.services.CarouseiimagesServices;
import com.ysj.blms.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/carouseiimages")
public class CarouseiimagesinfoController {


        @Autowired
        CarouseiimagesServices carouseiimagesServices;

        //分页带条件查询
        @PostMapping("/page")
        public ResultVo page(@RequestBody Carouseiimages carouseiimages, @RequestParam(defaultValue = "1")Integer pageNum){
            PageInfo pageInfo= carouseiimagesServices.getPage(carouseiimages, pageNum);
            return ResultVo.success("",pageInfo);
        }
    }

