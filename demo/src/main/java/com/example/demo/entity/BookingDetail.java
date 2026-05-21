package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "Booking_Detail")
public class BookingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @Email
    private String email;
    private String phoneNumber;
    private String route;
    private String  schedule;
    private String nameOfSeat;
    private Long numberOfSeat;
    private Long total;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Long getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(Long numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getNameOfSeat() {
        return nameOfSeat;
    }

    public void setNameOfSeat(String nameOfSeat) {
        this.nameOfSeat = nameOfSeat;
    }

    public BookingDetail(String fullName, String email, String route, String phoneNumber, String schedule, String nameOfSeat, Long numberOfSeat, Long total) {
        this.fullName = fullName;
        this.email = email;
        this.route = route;
        this.phoneNumber = phoneNumber;
        this.schedule = schedule;
        this.nameOfSeat=nameOfSeat;
        this.numberOfSeat = numberOfSeat;
        this.total = total;
    }
    public BookingDetail(){

    }
}
