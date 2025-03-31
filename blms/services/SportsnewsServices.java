package com.ysj.blms.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysj.blms.domain.Sportsnews;
import com.ysj.blms.mapper.SportsnewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportsnewsServices {
    @Autowired
    SportsnewsMapper sportsnewsMapper;

    public PageInfo getPage(Sportsnews sportsnews, Integer pageNum) {
        PageHelper.startPage(pageNum,5,"newsId");
        List<Sportsnews> list= sportsnewsMapper.selectBy(sportsnews);
        return new PageInfo(list);
    }
}
