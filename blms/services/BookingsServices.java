package com.ysj.blms.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.ysj.blms.domain.Bookings;
import com.ysj.blms.mapper.BookingsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingsServices {
    @Autowired
    BookingsMapper bookingsMapper;
    public PageInfo getPage(Bookings bookings, Integer pageNum) {
        PageHelper.startPage(pageNum,5,"bookingId");
        List<Bookings> list=bookingsMapper.selectBy(bookings);
        return new PageInfo(list);
    }

    public int createBooking(Bookings bookings) {
        return bookingsMapper.insertSelective(bookings);
    }

    public int deleteBooking(Long bookingid) {
        return bookingsMapper.deleteByPrimaryKey(bookingid);
    }

    public int confirmBooking(Long bookingid) {
        Bookings bookings = new Bookings();
        bookings.setBookingid(bookingid.intValue());
        bookings.setBookingstatus("已确认");
        return bookingsMapper.updateByPrimaryKeySelective(bookings);


    }
}
