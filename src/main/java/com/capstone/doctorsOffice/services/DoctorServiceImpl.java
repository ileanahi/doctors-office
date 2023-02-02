package com.capstone.doctorsOffice.services;

import com.capstone.doctorsOffice.dtos.DoctorDto;
import com.capstone.doctorsOffice.entities.Doctor;
import com.capstone.doctorsOffice.repositories.AppointmentRepository;
import com.capstone.doctorsOffice.repositories.DoctorRepository;
import com.capstone.doctorsOffice.repositories.PatientRepository;
import com.capstone.doctorsOffice.repositories.PrescriptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Override
    public List<DoctorDto> getAllDoctors() {
        return doctorRepository.findAll().stream().map(doctor -> new DoctorDto(doctor)).collect(Collectors.toList());
    }
    @Override
    public Optional<DoctorDto> getDoctorById(Long id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if (doctorOptional.isPresent()) {
            return Optional.of(new DoctorDto(doctorOptional.get()));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public List<String> addNewDoctor(DoctorDto doctorDto) {
        List<String> response = new ArrayList<>();
        Doctor doctor = new Doctor(doctorDto);
        doctorRepository.saveAndFlush(doctor);
        response.add("New Doctor added");
        return response;
    }

    @Override
    @Transactional
    public void deleteDoctor(Long id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        doctorOptional.ifPresent(doctor -> doctorRepository.delete(doctor));
    }

    @Override
    @Transactional
    public void updateDoctor(DoctorDto doctorDto) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorDto.getId());
        doctorOptional.ifPresent(doctor -> {
            doctor.setName(doctorDto.getName());
            doctor.setProfession(doctorDto.getProfession());
        });
    }
}
