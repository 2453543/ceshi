package com.ysj.blms.controller;

import com.github.pagehelper.PageInfo;
import com.ysj.blms.domain.Basketballcourse;
import com.ysj.blms.services.BasketballcourseServices;
import com.ysj.blms.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/basketballcourse")
public class BasketballcourseinfoController {
    @Autowired
    BasketballcourseServices basketballcourseServices;

    // 分页带条件查询
    @PostMapping("/page")
    public ResultVo page(@RequestBody Basketballcourse basketballcourse, @RequestParam(defaultValue = "1") Integer pageNum) {
        PageInfo pageInfo = basketballcourseServices.getPage(basketballcourse, pageNum);
        SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Basketballcourse> list = pageInfo.getList();
        for (Basketballcourse basketballcourseA : list) {
            if (basketballcourseA.getStarttime() != null) {
                basketballcourseA.setStarttimeStr(dateSdf.format(basketballcourseA.getStarttime()));
            }
            if (basketballcourseA.getEndtime() != null) {
                basketballcourseA.setEndtimeStr(dateSdf.format(basketballcourseA.getEndtime()));
            }
        }
        return ResultVo.success("", pageInfo);
    }

    // 上架课程
    @PutMapping("/online/{courseId}")
    public ResultVo onlineCourse(@PathVariable Long courseId) {
        // 将 Long 类型转换为 Integer 类型
        Integer courseIdInt = courseId.intValue();
        Basketballcourse basketballcourse = basketballcourseServices.getCourseById(courseIdInt);
        if (basketballcourse != null) {
            basketballcourse.setStatus("开放");
            basketballcourseServices.updateCourse(basketballcourse);
            return ResultVo.success("课程上架成功", null);
        }
        return ResultVo.error("课程不存在");
    }

    // 下架课程
    @PutMapping("/offline/{courseId}")
    public ResultVo offlineCourse(@PathVariable Long courseId) {
        // 将 Long 类型转换为 Integer 类型
        Integer courseIdInt = courseId.intValue();
        Basketballcourse basketballcourse = basketballcourseServices.getCourseById(courseIdInt);
        if (basketballcourse != null) {
            basketballcourse.setStatus("下架");
            basketballcourseServices.updateCourse(basketballcourse);
            return ResultVo.success("课程下架成功", null);
        }
        return ResultVo.error("课程不存在");
    }

    // 删除课程
    @DeleteMapping("/delete/{courseId}")
    public ResultVo deleteCourse(@PathVariable Long courseId) {
        // 将 Long 类型转换为 Integer 类型
        Integer courseIdInt = courseId.intValue();
        basketballcourseServices.deleteCourse(courseIdInt);
        return ResultVo.success("课程删除成功", null);
    }

    // 新增课程
    @PostMapping("/add")
    public ResultVo addCourse(@RequestBody Basketballcourse basketballcourse) {
        basketballcourseServices.addCourse(basketballcourse);
        return ResultVo.success("课程新增成功", null);
    }

    // 报名课程
    @PostMapping("/signup/{courseId}")
    public ResultVo signUpCourse(@PathVariable Long courseId) {
        // 将 Long 类型转换为 Integer 类型
        Integer courseIdInt = courseId.intValue();
        Basketballcourse basketballcourse = basketballcourseServices.getCourseById(courseIdInt);
        if (basketballcourse != null) {
            if (basketballcourse.getEnrolledstudents() < basketballcourse.getMaxstudents()) {
                basketballcourse.setEnrolledstudents(basketballcourse.getEnrolledstudents() + 1);
                if (basketballcourse.getEnrolledstudents() == basketballcourse.getMaxstudents()) {
                    basketballcourse.setStatus("已满");
                }
                basketballcourseServices.updateCourse(basketballcourse);
                return ResultVo.success("报名成功", null);
            }
            return ResultVo.error("课程已满，无法报名");
        }
        return ResultVo.error("课程不存在");
    }

    // 取消报名课程
    @PostMapping("/cancelSignup/{courseId}")
    public ResultVo cancelSignUpCourse(@PathVariable Long courseId) {
        // 将 Long 类型转换为 Integer 类型
        Integer courseIdInt = courseId.intValue();
        Basketballcourse basketballcourse = basketballcourseServices.getCourseById(courseIdInt);
        if (basketballcourse != null) {
            if (basketballcourse.getEnrolledstudents() > 0) {
                basketballcourse.setEnrolledstudents(basketballcourse.getEnrolledstudents() - 1);
                if (basketballcourse.getEnrolledstudents() < basketballcourse.getMaxstudents()) {
                    basketballcourse.setStatus("开放");
                }
                basketballcourseServices.updateCourse(basketballcourse);
                return ResultVo.success("取消报名成功", null);
            }
            return ResultVo.error("未报名该课程，无法取消");
        }
        return ResultVo.error("课程不存在");
    }
}