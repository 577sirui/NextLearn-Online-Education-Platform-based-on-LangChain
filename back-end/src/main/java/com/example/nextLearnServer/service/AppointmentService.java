package com.example.nextLearnServer.service;

import com.example.nextLearnServer.pojo.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> selectAllAppointment();
    List<Appointment> selectAppointmentByStudentId(int studentId);
    List<Appointment> selectAppointmentByTeacherId(int teacherId);
}
