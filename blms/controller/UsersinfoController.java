package com.ysj.blms.controller;
import com.github.pagehelper.PageInfo;
import com.ysj.blms.domain.Users;
import com.ysj.blms.services.UsersServices;
import com.ysj.blms.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersinfoController {
    @Autowired
    UsersServices usersservices;

    //分页带条件查询
    @PostMapping("/page")

    public ResultVo page(@RequestBody Users users, @RequestParam(defaultValue = "1")Integer pageNum){
        PageInfo pageInfo= usersservices.getPage(users, pageNum);



        return ResultVo.success("",pageInfo);

    }
}
