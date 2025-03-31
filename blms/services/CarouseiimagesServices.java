package com.ysj.blms.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysj.blms.domain.Carouseiimages;
import com.ysj.blms.mapper.CarouseiimagesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CarouseiimagesServices {
    @Autowired
    CarouseiimagesMapper carouseiimagesMapper;

    public PageInfo getPage(Carouseiimages carouseiimages, Integer pageNum) {
        PageHelper.startPage(pageNum,5,"imageTd");
        List<Carouseiimages> list= carouseiimagesMapper.selectBy(carouseiimages);
        return new PageInfo(list);
    }

}
