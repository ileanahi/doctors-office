package com.capstone.doctorsOffice.controllers;

import com.capstone.doctorsOffice.dtos.PatientDto;
import com.capstone.doctorsOffice.repositories.PatientRepository;
import com.capstone.doctorsOffice.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public List<String> addPatient(@RequestBody PatientDto patientDto){
        String passHash = passwordEncoder.encode(patientDto.getPassword());
        patientDto.setPassword(passHash);
        return patientService.addPatient(patientDto);
    }

    @PostMapping("/login")
    public List<String> patientLogin(@RequestBody PatientDto patientDto){
        return patientService.patientLogin(patientDto);
    }

    @GetMapping("/{id}")
    public Optional<PatientDto> getPatientById(@PathVariable Long patientId) {
        return patientService.getPatientById(patientId);
    }


}