package com.capstone.docctorsOffice.repositories;

import com.capstone.docctorsOffice.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long>{
    List<Prescription> findByDoctorId(Long doctorId); //instead of just Long id
    List<Prescription> findByPatientId(Long patientId);
}