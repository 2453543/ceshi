package com.ysj.blms.mapper;

import com.ysj.blms.domain.Sportsnews;

import java.util.List;

/**
* @author ysj
* @description 针对表【sportsnews】的数据库操作Mapper
* @createDate 2025-03-31 15:46:26
* @Entity mapper.domain.Sportsnews
*/
public interface SportsnewsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Sportsnews record);

    int insertSelective(Sportsnews record);

    Sportsnews selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Sportsnews record);

    int updateByPrimaryKey(Sportsnews record);

    List<Sportsnews> selectBy(Sportsnews sportsnews);
}
