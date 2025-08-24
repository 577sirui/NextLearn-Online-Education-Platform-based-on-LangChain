package com.example.nextLearnServer.service;

import com.example.nextLearnServer.pojo.Reservation;

import java.util.List;

public interface ReservationService {
    public void updateStatus(Reservation reservation);
    public List<Reservation> getAllReservations();
    public String getPassword(String reservationPosition);
}
