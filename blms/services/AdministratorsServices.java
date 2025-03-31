package com.ysj.blms.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysj.blms.domain.Administrators;
import com.ysj.blms.domain.Announcements;
import com.ysj.blms.mapper.AdministratorsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AdministratorsServices {
    @Autowired
    AdministratorsMapper administratorsMapper;

    public PageInfo getPage(Administrators administrators, Integer pageNum) {
        PageHelper.startPage(pageNum,5,"adminIdId");
        List<Announcements> list= administratorsMapper.selectBy(administrators);
        return new PageInfo(list);
    }
}
