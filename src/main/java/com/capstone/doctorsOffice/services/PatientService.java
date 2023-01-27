package com.capstone.doctorsOffice.services;

import com.capstone.doctorsOffice.dtos.PatientDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface PatientService {
    @Transactional
    List<String> addPatient(PatientDto patientDto);

    @Transactional
    List<String> patientLogin(PatientDto patientDto);


}
