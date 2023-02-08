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

    @PostMapping("/new-prescription")
    public List<String> addPrescription(@RequestBody PrescriptionDto prescriptionDto) {
        return prescriptionService.addPrescription(prescriptionDto);
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
