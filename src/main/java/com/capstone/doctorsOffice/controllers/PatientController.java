package com.capstone.doctorsOffice.controllers;

import com.capstone.doctorsOffice.dtos.PatientDto;
import com.capstone.doctorsOffice.repositories.PatientRepository;
import com.capstone.doctorsOffice.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/registerForm")
    public List<String> addPatient(@RequestBody Map<String, Object> body){

        // Get patientDto from Map
        Map<String, Object> patientDtoMap = (Map<String, Object>) body.get("patientDto");

        PatientDto patientDto = new PatientDto();
        patientDto.setName((String) patientDtoMap.get("name"));
        patientDto.setPhone((String) patientDtoMap.get("phone"));
        patientDto.setAddress((String) patientDtoMap.get("address"));
        patientDto.setEmail((String) patientDtoMap.get("email"));

        String passHash = passwordEncoder.encode((String) patientDtoMap.get("password"));
        patientDto.setPassword(passHash);

        Long doctorId = Long.parseLong((String) body.get("id"));

        return patientService.addPatient(patientDto, doctorId);
    }

    @PostMapping("/login")
    public List<String> patientLogin(@RequestBody PatientDto patientDto){
        return patientService.patientLogin(patientDto);
    }

    @GetMapping("/{id}")
    public Optional<PatientDto> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PutMapping("/{id}")
    public List<String> updatePatient(@PathVariable Long id, @RequestBody PatientDto patientDto){
        return patientService.updatePatient(id, patientDto);
    }


}