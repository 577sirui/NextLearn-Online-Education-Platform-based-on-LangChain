package com.example.nextLearnServer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment implements Serializable {
    private int id;
    private int studentId;
    private int teacherId;
    private int parentId;
    private Date appointmentTime;
}
