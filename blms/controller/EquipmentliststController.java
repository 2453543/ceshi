package com.ysj.blms.controller;
import com.github.pagehelper.PageInfo;
import com.ysj.blms.domain.Equipmentlistst;
import com.ysj.blms.services.EquipmentliststServices;
import com.ysj.blms.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/equipmentlistst")
public class EquipmentliststController {
    @Autowired
    EquipmentliststServices equipmentliststservices;
    //新增修改
    //分页带条件查询
    @PostMapping("/page")
    public ResultVo page(@RequestBody Equipmentlistst equipmentlistst, @RequestParam(defaultValue = "1")Integer pageNum){
        PageInfo pageInfo= equipmentliststservices.getPage(equipmentlistst, pageNum);
        SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy-MM-dd ");
        List<Equipmentlistst> list = pageInfo.getList();
        for (Equipmentlistst E : list) {
            if (E.getBorrowdate() != null) {
                E.setBorrowdateStr(dateSdf.format(E.getBorrowdate()));
            }
            if (E.getReturndate() != null) {
                E.setReturndateStr(dateSdf.format(E.getReturndate()));
            }
        }



        return ResultVo.success("",pageInfo);

    }


}
