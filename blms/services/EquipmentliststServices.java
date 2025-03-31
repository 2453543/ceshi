package com.ysj.blms.services;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysj.blms.domain.Equipmentlistst;
import com.ysj.blms.mapper.EquipmentliststMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EquipmentliststServices {

    @Autowired
    EquipmentliststMapper equipmentliststMapper;
    public PageInfo getPage(Equipmentlistst equipmentlistst, Integer pageNum) {
        PageHelper.startPage(pageNum,5,"borrowingid");
        List<Equipmentlistst> list = equipmentliststMapper.selectBy(equipmentlistst);
        return new PageInfo(list);
    }
}
