package com.example.nextLearnServer.service;

import com.example.nextLearnServer.mapper.AppointmentMapper;
import com.example.nextLearnServer.pojo.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Override
    public List<Appointment> selectAllAppointment() {
        return appointmentMapper.selectAllAppointment();
    }

    @Override
    public List<Appointment> selectAppointmentByStudentId(int studentId) {
        return appointmentMapper.selectAppointmentByStudentId(studentId);
    }

    @Override
    public List<Appointment> selectAppointmentByTeacherId(int teacherId) {
        return appointmentMapper.selectAppointmentByTeacherId(teacherId);
    }
}
