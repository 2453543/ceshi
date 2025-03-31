package com.ysj.blms.services;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysj.blms.domain.Sgvideo;
import com.ysj.blms.mapper.SgvideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SgvideoServices {

    @Autowired
    SgvideoMapper sgvideoMapper;
    public PageInfo getPage(Sgvideo sgvideo, Integer pageNum) {
        PageHelper.startPage(pageNum,5,"id");
        List<Sgvideo> list = sgvideoMapper.selectBy(sgvideo);
        return new PageInfo(list);
    }
}
