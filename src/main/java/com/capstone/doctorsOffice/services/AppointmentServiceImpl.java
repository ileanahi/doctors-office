package com.capstone.doctorsOffice.services;

import com.capstone.doctorsOffice.dtos.*;
import com.capstone.doctorsOffice.entities.*;
import com.capstone.doctorsOffice.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public void addNewAppointment(Long id, AppointmentDto appointmentDto){

        System.out.println("********* appointment service **********");
        System.out.println(appointmentDto);
        System.out.println(id);
        List<String> response = new ArrayList<>();
        Optional<Patient> patient = patientRepository.findById(id);
        Optional<Doctor> doctor = doctorRepository.findById(patient.get().getDoctor().getId());

        Appointment appointment = new Appointment(appointmentDto);
        patient.ifPresent(appointment::setPatient);
        doctor.ifPresent(appointment::setDoctor);

        appointmentRepository.saveAndFlush(appointment);
        patient.ifPresent(patient1 -> {
            patient1.setAppointment(appointment);
        });
        patientRepository.saveAndFlush(patient.get());
    }

    @Override
    @Transactional
    public void deleteAppointment(Long appointmentId){
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentId);
        appointmentOptional.ifPresent(appointment -> appointmentRepository.delete(appointment));
    }

    @Override
    @Transactional
    public void updateAppointment(Long appointmentId, AppointmentDto appointmentDto){
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentId);
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

    @Override
    public List<AppointmentDto> getAllAppointments(){
        return appointmentRepository.findAll().stream().map(appointment ->
                new AppointmentDto(appointment)).collect(Collectors.toList());
    }

}
