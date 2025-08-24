package com.example.nextLearnServer.mapper;

import com.example.nextLearnServer.pojo.Reservation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {
    public void updateStatus(Reservation reservation);
    public List<Reservation> getAllReservations();
    public String getPassword(String reservationPosition);
}
