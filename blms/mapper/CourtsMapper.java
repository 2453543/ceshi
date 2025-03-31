package com.ysj.blms.mapper;

import com.ysj.blms.domain.Courts;

import java.util.List;

/**
* @author ysj
* @description 针对表【courts(此表用于存储篮球馆内各个场地的基本信息，辅助篮球馆管理场地资源。)】的数据库操作Mapper
* @createDate 2025-03-28 16:15:16
* @Entity mapper.domain.Courts
*/
public interface CourtsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Courts record);

    int insertSelective(Courts record);

    Courts selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Courts record);

    int updateByPrimaryKey(Courts record);

    List<Courts> selectBy(Courts courts);
    int updateCourtState(Courts courts);
    int updateCourtInfo(Courts courts);
}
