package com.ysj.blms.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.ysj.blms.domain.Courts;
import com.ysj.blms.mapper.CourtsMapper;
import com.ysj.blms.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourtsServices {
    @Autowired
    CourtsMapper courtsMapper;

    public PageInfo getPage(Courts courts, Integer pageNum) {
        PageHelper.startPage(pageNum,5,"courtId");
        List<Courts> list= courtsMapper.selectBy(courts);
        return new PageInfo(list);
    }
    //更新状态
    public ResultVo updateCourtState(Courts courts) {
        String state = courts.getState();
        if (!"开启".equals(state) && !"关闭".equals(state)) {
            return ResultVo.error("场地状态值不合法，只能是 '开启' 或 '关闭'");
        }
        int result = courtsMapper.updateByPrimaryKeySelective(courts);
        if (result > 0) {
            return ResultVo.success("场地状态更新成功", null);
        } else {
            return ResultVo.error("场地状态更新失败");
        }

    }

    public int updateCourtInfo(Courts courts) {
        return courtsMapper.updateCourtInfo(courts);
    }




}
