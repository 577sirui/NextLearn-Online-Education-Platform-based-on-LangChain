package com.example.nextLearnServer.mapper;

import com.example.nextLearnServer.pojo.Appointment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AppointmentMapper {
    List<Appointment> selectAllAppointment();
    List<Appointment> selectAppointmentByStudentId(int studentId);
    List<Appointment> selectAppointmentByTeacherId(int teacherId);
}
