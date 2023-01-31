package com.capstone.doctorsOffice.controllers;

import com.capstone.doctorsOffice.dtos.DoctorDto;
import com.capstone.doctorsOffice.repositories.DoctorRepository;
import com.capstone.doctorsOffice.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("")
    public List<DoctorDto> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{doctorId}")
    public Optional<DoctorDto> getDoctorById(@PathVariable Long doctorId) {
        return doctorService.getDoctorById(doctorId);
    }

    @PostMapping("/new-doctor")
    public List<String> addNewDoctor(@RequestBody DoctorDto doctorDto) {
        return doctorService.addNewDoctor(doctorDto);
    }

    @DeleteMapping("/{doctorId}")
    public void deleteDoctor(@PathVariable Long doctorId) {
        doctorService.deleteDoctor(doctorId);
    }

    @PutMapping("/{doctorId}")
    public void updateDoctor(@PathVariable Long doctorId, @RequestBody DoctorDto doctorDto) {
        doctorService.updateDoctor(doctorDto);
    }

}
