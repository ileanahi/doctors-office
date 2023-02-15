package com.capstone.doctorsOffice.services;

import com.capstone.doctorsOffice.dtos.PatientDto;
import com.capstone.doctorsOffice.entities.Doctor;
import com.capstone.doctorsOffice.entities.Patient;
import com.capstone.doctorsOffice.repositories.DoctorRepository;
import com.capstone.doctorsOffice.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private DoctorRepository doctorRepository;


    @Override
    public List<String> addPatient(PatientDto patientDto, Long id) {
        System.out.println("*********** inside addPatient");
        List<String> response = new ArrayList<>();
        Patient patient = new Patient(patientDto);
        System.out.println(patient);
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        System.out.println(doctor);
        patient.setDoctor(doctor);
        patientRepository.saveAndFlush(patient);
        response.add("Patient Successfully added");
        return response;
    }

    @Override
    @Transactional
    public List<String> patientLogin(PatientDto patientDto){
        List<String> response = new ArrayList<>();
        Optional<Patient> patientOptional = patientRepository.findByEmail(patientDto.getEmail());
        if (patientOptional.isPresent()) {
            if (passwordEncoder.matches(patientDto.getPassword(), patientOptional.get().getPassword())) {
                response.add("Patient login successful");
                response.add(String.valueOf(patientOptional.get().getId()));
            } else {
                response.add("Patient Login Failed");
            }
        } else {
            response.add("Patient Login Failed");
        }
        return response;
    }

    @Override
    public Optional<PatientDto> getPatientById(@PathVariable Long id){
        Optional<Patient> patientOptional = patientRepository.findById(id);
        return patientOptional.map(PatientDto::new);
    }

    @Override
    @Transactional
    public List<String> updatePatient(Long id, PatientDto patientDto){
        List<String> response = new ArrayList<>();
        Optional<Patient> patientOptional = patientRepository.findById(id);
        patientOptional.ifPresent(patient -> {
            patient.setName(patientDto.getName());
            patient.setEmail(patientDto.getEmail());
            patient.setAddress(patientDto.getAddress());
        });
        response.add("Patient Successfully updated");

        return response;
    }

}
