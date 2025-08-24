package com.example.nextLearnServer.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    private int id;
    private String name;
    private String studentId;
    private String status;
    private String reservationPosition;
    private String password;
    private String createTime;
}
