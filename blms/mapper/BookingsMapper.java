package com.ysj.blms.mapper;

import com.ysj.blms.domain.Bookings;

import java.util.List;

/**
* @author ysj
* @description 针对表【bookings(此表用于存储篮球馆场地的预订相关信息，通过关联用户和场地表，记录每个预订的时间、状态等内容，方便篮球馆管理预订业务。)】的数据库操作Mapper
* @createDate 2025-03-28 16:15:16
* @Entity mapper.domain.Bookings
*/
public interface BookingsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Bookings record);

    int insertSelective(Bookings record);

    Bookings selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Bookings record);

    int updateByPrimaryKey(Bookings record);

    List<Bookings> selectBy(Bookings bookings);

}
