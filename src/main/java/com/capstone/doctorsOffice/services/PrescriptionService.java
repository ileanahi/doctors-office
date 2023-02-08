package com.capstone.doctorsOffice.services;

import com.capstone.doctorsOffice.dtos.PrescriptionDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface PrescriptionService {

    @Transactional
    List<String> addPrescription(PrescriptionDto prescriptionDto);

    @Transactional
    void deletePrescription(Long prescriptionId);

    @Transactional
    void updatePrescription(Long prescriptionId, PrescriptionDto prescriptionDto);

    Optional<PrescriptionDto> getPrescriptionById(Long prescriptionId);

    List<PrescriptionDto> getAllPrescriptions();
}






