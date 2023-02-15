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

        System.out.println("*********** patientDtoMap:");
        System.out.println(patientDtoMap);

        PatientDto patientDto = new PatientDto();
        patientDto.setName((String) patientDtoMap.get("name"));
        patientDto.setAddress((String) patientDtoMap.get("address"));
        patientDto.setEmail((String) patientDtoMap.get("email"));

        String passHash = passwordEncoder.encode((String) patientDtoMap.get("password"));
        patientDto.setPassword(passHash);

        System.out.println("*********** patientDto:");
        System.out.println(patientDto);


//        // Get and set Doctor object
//        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
//        if (doctorOptional.isPresent()) {
//            patient.setDoctor(doctorOptional.get());
//        } else {
//            // Handle doctor not found error
//        }

        Long doctorId = Long.parseLong((String) body.get("id"));
        System.out.println("*********** doctor id:");
        System.out.println(doctorId);



        return patientService.addPatient(patientDto, doctorId);
    }

    @PostMapping("/login")
    public List<String> patientLogin(@RequestBody PatientDto patientDto){
        System.out.println("************  inside login controller !!!!!!!!!!!! ^^^^^^^^^^^^^^^^^^^");
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