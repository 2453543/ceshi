package com.ysj.blms.controller;
import com.github.pagehelper.PageInfo;
import com.ysj.blms.domain.Courts;
import com.ysj.blms.services.CourtsServices;
import com.ysj.blms.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courts")
public class CourtsinfoController {
    @Autowired
    CourtsServices courtsservices;

    //分页带条件查询
    @PostMapping("/page")
    public ResultVo page(@RequestBody Courts courts, @RequestParam(defaultValue = "1")Integer pageNum){
        PageInfo pageInfo= courtsservices.getPage(courts, pageNum);
        return ResultVo.success("",pageInfo);
    }
    @PostMapping("/updateState")
    public ResultVo updateCourtState(@RequestBody Courts courts) {
        return courtsservices.updateCourtState(courts);
    }
    // 添加处理场地信息修改的方法
    @PostMapping("/updateInfo")
    public ResultVo updateCourtInfo(@RequestBody Courts courts) {
        int result = courtsservices.updateCourtInfo(courts);
        if (result > 0) {
            return ResultVo.success("场地信息修改成功", null);
        } else {
            return ResultVo.error("场地信息修改失败");
        }
    }


}
