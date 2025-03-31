package com.ysj.blms.controller;

import com.github.pagehelper.PageInfo;
import com.ysj.blms.domain.Administrators;
import com.ysj.blms.services.AdministratorsServices;
import com.ysj.blms.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/administrators")
public class AdministratorsinfoController {

        @Autowired
        AdministratorsServices  administratorsServices;

        //分页带条件查询
        @PostMapping("/page")
        public ResultVo page(@RequestBody Administrators administrators, @RequestParam(defaultValue = "1")Integer pageNum){
            PageInfo pageInfo= administratorsServices.getPage(administrators, pageNum);
            return ResultVo.success("",pageInfo);
        }
}
