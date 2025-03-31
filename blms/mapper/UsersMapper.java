package com.ysj.blms.mapper;

import com.ysj.blms.domain.Users;

import java.util.List;

/**
* @author ysj
* @description 针对表【users(存储篮球馆管理系统中的用户信息，包括登录凭证、个人信息和用户类型等)】的数据库操作Mapper
* @createDate 2025-03-28 16:15:16
* @Entity mapper.domain.Users
*/
public interface UsersMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    List<Users> selectBy(Users users);
}
