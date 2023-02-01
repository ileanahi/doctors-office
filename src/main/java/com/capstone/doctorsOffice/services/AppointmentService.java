package com.capstone.doctorsOffice.services;

import com.capstone.doctorsOffice.dtos.AppointmentDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    @Transactional
    List<String> addNewAppointment(AppointmentDto appointmentDto);

    @Transactional
    void deleteAppointment(Long appointmentId);

    @Transactional
    void updateAppointment(Long appointmentId, AppointmentDto appointmentDto);

    Optional<AppointmentDto> getAppointmentById(Long appointmentId);

    List<AppointmentDto> getAllAppointments();
}
