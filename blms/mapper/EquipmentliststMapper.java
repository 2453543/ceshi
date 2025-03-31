package com.ysj.blms.mapper;

import com.ysj.blms.domain.Equipmentlistst;

import java.util.List;

/**
* @author ysj
* @description 针对表【equipmentlistst】的数据库操作Mapper
* @createDate 2025-03-28 16:15:16
* @Entity mapper.domain.Equipmentlistst
*/
public interface EquipmentliststMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Equipmentlistst record);

    int insertSelective(Equipmentlistst record);

    Equipmentlistst selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Equipmentlistst record);

    int updateByPrimaryKey(Equipmentlistst record);

    List<Equipmentlistst> selectBy(Equipmentlistst equipmentlistst);

}
