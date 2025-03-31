package com.ysj.blms.controller;

import com.github.pagehelper.PageInfo;
import com.ysj.blms.domain.Bookings;
import com.ysj.blms.services.BookingsServices;
import com.ysj.blms.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingsinfoController {
    @Autowired
    BookingsServices bookingsservices;

    // 分页带条件查询
    @PostMapping("/page")
    public ResultVo page(@RequestBody Bookings bookings, @RequestParam(defaultValue = "1") Integer pageNum) {
        PageInfo pageInfo = bookingsservices.getPage(bookings, pageNum);
        SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy-MM-dd ");
        SimpleDateFormat timeSdf = new SimpleDateFormat("HH:mm:ss");
        List<Bookings> list = pageInfo.getList();
        for (Bookings booking : list) {
            if (booking.getBookingdate() != null) {
                booking.setBookingdateStr(dateSdf.format(booking.getBookingdate()));
            }
            if (booking.getStarttime() != null) {
                booking.setStarttimeStr(timeSdf.format(booking.getStarttime()));
            }
            if (booking.getEndtime() != null) {
                booking.setEndtimeStr(timeSdf.format(booking.getEndtime()));
            }
        }
        return ResultVo.success("", pageInfo);
    }

    @PostMapping("/create")
    public ResultVo createBooking(@RequestBody Bookings bookings) {
        // 订单默认状态为待处理
        bookings.setBookingstatus("待处理");
        int result = bookingsservices.createBooking(bookings);
        if (result > 0) {
            return ResultVo.success("订单创建成功", null);
        } else {
            return ResultVo.error("订单创建失败");
        }
    }

    @DeleteMapping("/delete/{bookingid}")
    public ResultVo deleteBooking(@PathVariable Long bookingid) {
        int result = bookingsservices.deleteBooking(bookingid);
        if (result > 0) {
            return ResultVo.success("订单删除成功", null);
        } else {
            return ResultVo.error("订单删除失败");
        }
    }

    @PutMapping("/confirm/{bookingid}")
    public ResultVo confirmBooking(@PathVariable Long bookingid) {
        int result = bookingsservices.confirmBooking(bookingid);
        if (result > 0) {
            return ResultVo.success("订单确认成功", null);
        } else {
            return ResultVo.error("订单确认失败");
        }
    }
}