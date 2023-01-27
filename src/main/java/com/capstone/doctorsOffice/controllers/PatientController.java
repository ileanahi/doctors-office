package com.capstone.doctorsOffice.controllers;

import com.capstone.doctorsOffice.dtos.PatientDto;
import com.capstone.doctorsOffice.repositories.PatientRepository;
import com.capstone.doctorsOffice.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}