package com.capstone.doctorsOffice.controllers;

import com.capstone.doctorsOffice.dtos.PrescriptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.capstone.doctorsOffice.services.PrescriptionService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prescriptions")


public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;


    @GetMapping("")
    public List<PrescriptionDto> getAllPrescription() {
        return prescriptionService.getAllPrescriptions();
    }

    @GetMapping("/{id}")
    public Optional<PrescriptionDto> getPrescriptionById(@PathVariable Long id) {
        return prescriptionService.getPrescriptionById(id);
    }

    @PostMapping("/new-prescription/{id}")
    public List<String> addPrescription(@PathVariable Long id, @RequestBody PrescriptionDto prescriptionDto) {
        System.out.println(prescriptionDto);
        System.out.println(id);
        return prescriptionService.addPrescription(id, prescriptionDto);
    }

    @DeleteMapping("/{id}")
    public void deletePrescription(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
    }

    @PutMapping("/{id}")
    public void updatePrescription(@PathVariable Long id, @RequestBody PrescriptionDto prescriptionDto) {
        prescriptionService.updatePrescription(id, prescriptionDto);
    }
}
