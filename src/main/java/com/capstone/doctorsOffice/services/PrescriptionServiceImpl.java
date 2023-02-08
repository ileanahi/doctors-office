package com.capstone.doctorsOffice.services;

import com.capstone.doctorsOffice.dtos.PrescriptionDto;
import com.capstone.doctorsOffice.entities.Prescription;
import com.capstone.doctorsOffice.repositories.PrescriptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    @Transactional
    public List<String> addPrescription(PrescriptionDto prescriptionDto){
        List<String> response = new ArrayList<>();
        Prescription prescription = new Prescription(prescriptionDto);
        prescriptionRepository.saveAndFlush(prescription);
        response.add("New Prescription Added");
        return response;
    }

    @Override
    @Transactional
    public void deletePrescription(Long prescriptionId){
        Optional<Prescription> prescriptionOptional = prescriptionRepository.findById(prescriptionId);
        prescriptionOptional.ifPresent(prescription -> prescriptionRepository.delete(prescription));
    }

    @Override
    @Transactional
    public void updatePrescription(Long prescriptionId, PrescriptionDto prescriptionDto){
        Optional<Prescription> prescriptionOptional = prescriptionRepository.findById(prescriptionId);
        prescriptionOptional.ifPresent(prescription -> {
            prescription.setPrescription(prescriptionDto.getPrescription());
            prescription.setFilled(prescriptionDto.getFilled());
            prescription.setDate(prescriptionDto.getDate());
        });
    }

    @Override
    public Optional<PrescriptionDto> getPrescriptionById(Long prescriptionId){
        Optional<Prescription> prescriptionOptional = prescriptionRepository.findById(prescriptionId);
        if (prescriptionOptional.isPresent()){
            return Optional.of(new PrescriptionDto(prescriptionOptional.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<PrescriptionDto> getAllPrescriptions(){
        return prescriptionRepository.findAll().stream().map(prescription ->
                new PrescriptionDto(prescription)).collect(Collectors.toList());
    }

}
