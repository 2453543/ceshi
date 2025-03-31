package com.ysj.blms.mapper;

import com.ysj.blms.domain.Announcements;

import java.util.List;

/**
* @author ysj
* @description 针对表【announcements】的数据库操作Mapper
* @createDate 2025-03-31 15:45:24
* @Entity mapper.domain.Announcements
*/
public interface AnnouncementsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Announcements record);

    int insertSelective(Announcements record);

    Announcements selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Announcements record);

    int updateByPrimaryKey(Announcements record);

    List<Announcements> selectBy(Announcements announcements);
}
