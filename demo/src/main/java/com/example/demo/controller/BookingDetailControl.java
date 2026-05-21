package com.example.demo.controller;

import com.example.demo.entity.BookingDetail;
import com.example.demo.service.BookingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Booking")
@CrossOrigin(origins = "*")
public class BookingDetailControl {
    @Autowired
    private BookingDetailService bookingDetailService;

@PostMapping("/save")
    public ResponseEntity<BookingDetail> save(@RequestBody BookingDetail bookingDetail){
        return new ResponseEntity<>(bookingDetailService.save(bookingDetail), HttpStatus.OK);
    }

    @GetMapping("/history/{email}")
    public ResponseEntity<List<BookingDetail>> getHistory(@PathVariable String email) {
        return ResponseEntity.ok(bookingDetailService.getByEmail(email));
    }
}
