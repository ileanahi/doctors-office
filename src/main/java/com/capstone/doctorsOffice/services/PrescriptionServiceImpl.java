package com.capstone.doctorsOffice.services;

import com.capstone.doctorsOffice.dtos.PrescriptionDto;
import com.capstone.doctorsOffice.entities.Appointment;
import com.capstone.doctorsOffice.entities.Doctor;
import com.capstone.doctorsOffice.entities.Patient;
import com.capstone.doctorsOffice.entities.Prescription;
import com.capstone.doctorsOffice.repositories.DoctorRepository;
import com.capstone.doctorsOffice.repositories.PatientRepository;
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

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    @Transactional
    public List<String> addPrescription(Long id, PrescriptionDto prescriptionDto){
        System.out.println("**************");

        System.out.println(prescriptionDto);
        System.out.println(id);

        List<String> response = new ArrayList<>();
        Optional<Patient> patient = patientRepository.findById(id);
        Optional<Doctor> doctor = doctorRepository.findById(patient.get().getDoctor().getId());

        System.out.println(patient);
        System.out.println(doctor);
        Prescription prescription = new Prescription(prescriptionDto);
        patient.ifPresent(prescription::setPatient);
        doctor.ifPresent(prescription::setDoctor);

        prescriptionRepository.saveAndFlush(prescription);
        response.add("New Prescription created.");
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
