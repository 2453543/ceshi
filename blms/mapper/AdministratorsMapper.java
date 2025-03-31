package com.ysj.blms.mapper;

import com.ysj.blms.domain.Administrators;
import com.ysj.blms.domain.Announcements;

import java.util.List;

/**
* @author ysj
* @description 针对表【administrators】的数据库操作Mapper
* @createDate 2025-03-31 15:45:24
* @Entity mapper.domain.Administrators
*/
public interface AdministratorsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Administrators record);

    int insertSelective(Administrators record);

    Administrators selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Administrators record);

    int updateByPrimaryKey(Administrators record);

    List<Announcements> selectBy(Administrators administrators);
}
