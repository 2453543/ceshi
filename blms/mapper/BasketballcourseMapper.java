package com.ysj.blms.mapper;

import com.ysj.blms.domain.Basketballcourse;

import java.util.List;

/**
* @author ysj
* @description 针对表【basketballcourse(用于保存课程学习的表)】的数据库操作Mapper
* @createDate 2025-03-28 16:15:16
* @Entity mapper.domain.Basketballcourse
*/
public interface BasketballcourseMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Basketballcourse record);

    int insertSelective(Basketballcourse record);

    Basketballcourse selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Basketballcourse record);

    int updateByPrimaryKey(Basketballcourse record);

    List<Basketballcourse> selectBy(Basketballcourse basketballcourse);
}
