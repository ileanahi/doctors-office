package com.capstone.doctorsOffice.controllers;

import com.capstone.doctorsOffice.dtos.AppointmentDto;
import com.capstone.doctorsOffice.repositories.AppointmentRepository;
import com.capstone.doctorsOffice.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("")
    public List<AppointmentDto> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{appointmentId}")
    public Optional<AppointmentDto> getAppointmentById(@PathVariable Long appointmentId) {
        return appointmentService.getAppointmentById(appointmentId);
    }

    @PostMapping("/{patientId}/newAppointment")
    public List<String> addNewAppointment(@PathVariable Long patientId, @ModelAttribute AppointmentDto appointmentDto) {
        return appointmentService.addNewAppointment(patientId, appointmentDto);
    }

    @DeleteMapping("/{appointmentId}")
    public void deleteAppointment(@PathVariable Long appointmentId){
        appointmentService.deleteAppointment(appointmentId);
    }

    @PutMapping("/{appointmentId}")
    public void updateAppointment(@PathVariable Long appointmentId,
                                  @RequestBody AppointmentDto appointmentDto){
        appointmentService.updateAppointment(appointmentId, appointmentDto);
    }
}
