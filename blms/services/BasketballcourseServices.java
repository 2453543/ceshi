package com.ysj.blms.services;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysj.blms.domain.Basketballcourse;
import com.ysj.blms.mapper.BasketballcourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class BasketballcourseServices {
    @Autowired
    BasketballcourseMapper basketballcourseMapper;
    public PageInfo getPage(Basketballcourse basketballcourse, Integer pageNum) {
        PageHelper.startPage(pageNum,5,"courseId");
        List<Basketballcourse> list = basketballcourseMapper.selectBy(basketballcourse);
        return new PageInfo(list);
    }
    public Basketballcourse getCourseById(Integer courseid) {
        return basketballcourseMapper.selectByPrimaryKey(Long.valueOf(courseid));
    }

    public void updateCourse(Basketballcourse course) {
        basketballcourseMapper.updateByPrimaryKey(course);
    }

    public void deleteCourse(Integer courseid) {
        basketballcourseMapper.deleteByPrimaryKey(Long.valueOf(courseid));
    }

    public void addCourse(Basketballcourse course) {
        basketballcourseMapper.insert(course);
    }



}
