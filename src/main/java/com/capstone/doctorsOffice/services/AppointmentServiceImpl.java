package com.capstone.doctorsOffice.services;

import com.capstone.doctorsOffice.dtos.*;
import com.capstone.doctorsOffice.entities.*;
import com.capstone.doctorsOffice.repositories.*;
import jakarta.transaction.Transactional;
import org.hibernate.sql.ast.tree.expression.Over;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Override
    @Transactional
    public List<String> addNewAppointment(AppointmentDto appointmentDto){
        List<String> response = new ArrayList<>();
        Appointment appointment = new Appointment(appointmentDto);
        appointmentRepository.saveAndFlush(appointment);
        response.add("New Appointment Scheduled");
        return response;
    }

    @Override
    @Transactional
    public void deleteAppointment(Long appointmentId){
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentId);
        appointmentOptional.ifPresent(appointment -> appointmentRepository.delete(appointment));
    }

    @Override
    @Transactional
    public void updateAppointment(AppointmentDto appointmentDto){
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentDto.getAppointmentId());
        appointmentOptional.ifPresent(appointment -> {
            appointment.setTime(appointmentDto.getTime());
            appointment.setDay(appointmentDto.getDay());
        });
    }

    @Override
    public Optional<AppointmentDto> getAppointmentById(Long appointmentId){
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentId);
        if (appointmentOptional.isPresent()){
            return Optional.of(new AppointmentDto(appointmentOptional.get()));
        }
        return Optional.empty();
    }

//    @Override
//    public List<AppointmentDto> getAllAppointmentsByDoctorId(Long doctorId){
//        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
//        if(doctorOptional.isPresent()) {
//            List<Appointment> appointmentList = appointmentRepository.findByDoctorId(doctorOptional.get().getDoctorId());
//            return appointmentList.stream().map(appointment -> new AppointmentDto(appointment)).collect(Collectors.toList());
//        }
//        return Collections.emptyList();
//    }


}
