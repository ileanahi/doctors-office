package com.capstone.doctorsOffice.services;

import com.capstone.doctorsOffice.dtos.PatientDto;
import com.capstone.doctorsOffice.entities.Patient;
import com.capstone.doctorsOffice.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<String> addPatient(PatientDto patientDto) {
        List<String> response = new ArrayList<>();
        Patient patient = new Patient(patientDto);
        patientRepository.saveAndFlush(patient);
        response.add("http://localhost:8080/login.html");
        return response;
    }

    @Override
    @Transactional
    public List<String> patientLogin(PatientDto patientDto){
        List<String> response = new ArrayList<>();
        Optional<Patient> patientOptional = patientRepository.findByName(patientDto.getName());
        if (patientOptional.isPresent()) {
            if (passwordEncoder.matches(patientDto.getPassword(), patientOptional.get().getPassword())) {
                response.add("http://localhost:8080/");
                response.add(String.valueOf(patientOptional.get().getId()));
            } else {
                response.add("Patient Login Failed");
            }
        } else {
            response.add("Patient Login Failed");
        }
        return response;
    }

}
