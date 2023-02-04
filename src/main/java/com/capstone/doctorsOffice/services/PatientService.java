package com.capstone.doctorsOffice.services;

import com.capstone.doctorsOffice.dtos.PatientDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    @Transactional
    List<String> addPatient(PatientDto patientDto);

    @Transactional
    List<String> patientLogin(PatientDto patientDto);

    Optional<PatientDto> getPatientById(Long patientId);

    @Transactional
    List<String> updatePatient(Long id, PatientDto patientDto);
}
