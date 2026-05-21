package com.example.demo.service;

import com.example.demo.entity.BookingDetail;
import com.example.demo.repository.BookingDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingDetailService {
    @Autowired
    private BookingDetailRepository bookingDetailRepository;

    public BookingDetail save(BookingDetail bookingDetail){
        return bookingDetailRepository.save(bookingDetail);
    }

    public List<BookingDetail> getByEmail(String email) {
        return bookingDetailRepository.findByEmail(email);
    }


}
