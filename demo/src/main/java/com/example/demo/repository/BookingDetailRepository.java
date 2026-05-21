package com.example.demo.repository;

import com.example.demo.entity.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDetailRepository extends JpaRepository<BookingDetail,Long> {
    List<BookingDetail> findByEmail(String email);

}
