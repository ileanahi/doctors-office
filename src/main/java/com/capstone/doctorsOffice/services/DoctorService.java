package com.capstone.doctorsOffice.services;

import com.capstone.doctorsOffice.dtos.DoctorDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    List<DoctorDto> getAllDoctors();

    Optional<DoctorDto> getDoctorById(Long id);

    @Transactional
    List<String> addNewDoctor(DoctorDto doctorDto);

    @Transactional
    void deleteDoctor(Long id);

    @Transactional
    void updateDoctor(DoctorDto doctorDto);
}
