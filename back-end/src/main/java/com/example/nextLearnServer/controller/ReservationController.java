package com.example.nextLearnServer.controller;

import com.example.nextLearnServer.pojo.Reservation;
import com.example.nextLearnServer.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    private ReservationService service;

    //requisition
    @PostMapping("/reservation/occupy")
    public void occupyPosition(@RequestParam("name") String name,
                               @RequestParam("studentId") String studentId,
                               @RequestParam("reservationPosition") String reservationPosition,
                               @RequestParam("password") String password) {
        Reservation reservation = new Reservation();
        reservation.setName(name);
        reservation.setStudentId(studentId);
        reservation.setReservationPosition(reservationPosition);
        reservation.setPassword(password);
        reservation.setStatus("1");
        System.out.println(reservation);
        service.updateStatus(reservation);
    }

    //Release position
    @PostMapping("/reservation/free")
    public String freePosition(@RequestParam("reservationPosition") String reservationPosition,
                             @RequestParam("password") String password) {
        Reservation reservation = new Reservation();
        reservation.setReservationPosition(reservationPosition);
        reservation.setPassword("暂无");
        reservation.setName("暂无");
        reservation.setStudentId("暂无");
        reservation.setStatus("0");
        String passwordCheck = service.getPassword(reservationPosition);
        if(!password.equals(passwordCheck)) {
            System.out.println("密码有错误");
            return "-1";
        }
        service.updateStatus(reservation);
        return String.valueOf(0);
    }

    //Get all the slots
    @GetMapping("/reservation/getAll")
    public List<Reservation> getAll() {
        return service.getAllReservations();
    }

}
