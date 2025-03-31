package com.ysj.blms.services;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysj.blms.domain.Announcements;
import com.ysj.blms.mapper.AnnouncementsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AnnouncementsServices {
    @Autowired
    AnnouncementsMapper announcementsMapper;

    public PageInfo getPage(Announcements announcements, Integer pageNum) {
        PageHelper.startPage(pageNum,5,"announcementId");
        List<Announcements> list= announcementsMapper.selectBy(announcements);
        return new PageInfo(list);
    }
}
