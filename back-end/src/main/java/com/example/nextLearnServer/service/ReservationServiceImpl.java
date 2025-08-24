package com.example.nextLearnServer.service;

import com.example.nextLearnServer.mapper.ReservationMapper;
import com.example.nextLearnServer.pojo.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationMapper mapper;

    @Override
    public void updateStatus(Reservation reservation) {
        mapper.updateStatus(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return mapper.getAllReservations();
    }

    @Override
    public String getPassword(String reservationPosition) {
        return mapper.getPassword(reservationPosition);
    }
}
