package com.example.nextLearnServer.controller;

import com.example.nextLearnServer.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/appointment/selectAllAppointments")
    public Object selectAllAppointments() {
        return appointmentService.selectAllAppointment();
    }

    @GetMapping("/appointment/selectAppointmentByStudentId")
    public Object selectAppointmentByStudentId(HttpServletRequest req) {
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        return appointmentService.selectAppointmentByStudentId(studentId);
    }

    @GetMapping("/appointment/selectAppointmentByTeacherId")
    public Object selectAppointmentByTeacherId(HttpServletRequest req) {
        int teacherId = Integer.parseInt(req.getParameter("teacherId"));
        return appointmentService.selectAppointmentByTeacherId(teacherId);
    }
}
