package com.ysj.blms.mapper;

import com.ysj.blms.domain.Carouseiimages;

import java.util.List;

/**
* @author ysj
* @description 针对表【carouseiimages】的数据库操作Mapper
* @createDate 2025-03-31 15:46:14
* @Entity mapper.domain.Carouseiimages
*/
public interface CarouseiimagesMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Carouseiimages record);

    int insertSelective(Carouseiimages record);

    Carouseiimages selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Carouseiimages record);

    int updateByPrimaryKey(Carouseiimages record);

    List<Carouseiimages> selectBy(Carouseiimages carouseiimages);
}
