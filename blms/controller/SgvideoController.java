package com.ysj.blms.controller;
import com.github.pagehelper.PageInfo;
import com.ysj.blms.domain.Sgvideo;
import com.ysj.blms.services.SgvideoServices;
import com.ysj.blms.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/sgvideo")
public class SgvideoController {
    @Autowired
    SgvideoServices sgvideoServices;
    //新增修改
    //分页带条件查询
    @PostMapping("/page")
    public ResultVo page(@RequestBody Sgvideo sgvideo, @RequestParam(defaultValue = "1")Integer pageNum){
        PageInfo pageInfo= sgvideoServices.getPage(sgvideo, pageNum);
        SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Sgvideo> list = pageInfo.getList();
        for (Sgvideo E : list) {
            if (E.getCreatetime() != null) {
                E.setCreatetimeStr(dateSdf.format(E.getCreatetime()));
            }
            if (E.getUpdatetime() != null) {
                E.setUpdatetimeStr(dateSdf.format(E.getUpdatetime()));
            }
        }



        return ResultVo.success("",pageInfo);

    }


}
