package com.ysj.blms.services;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysj.blms.domain.Users;
import com.ysj.blms.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsersServices {

    @Autowired
    UsersMapper usersMapper;
    public PageInfo getPage(Users users, Integer pageNum) {
        PageHelper.startPage(pageNum, 5, "userid");
        List<Users> list = usersMapper.selectBy(users);

        return new PageInfo(list);
    }
}
