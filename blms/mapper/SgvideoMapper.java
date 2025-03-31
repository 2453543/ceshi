package com.ysj.blms.mapper;

import com.ysj.blms.domain.Sgvideo;

import java.util.List;

/**
* @author ysj
* @description 针对表【sgvideo(用于保存学习页面的视频信息的表)】的数据库操作Mapper
* @createDate 2025-03-28 16:15:16
* @Entity mapper.domain.Sgvideo
*/
public interface SgvideoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Sgvideo record);

    int insertSelective(Sgvideo record);

    Sgvideo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Sgvideo record);

    int updateByPrimaryKey(Sgvideo record);

    List<Sgvideo> selectBy(Sgvideo sgvideo);
}
