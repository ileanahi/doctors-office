package com.capstone.doctorsOffice.repositories;

import com.capstone.doctorsOffice.entities.Patient;
import com.capstone.doctorsOffice.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long>{
    List<Prescription> findByDoctorId(Long doctorId);
    List<Prescription> findByPatientId(Long patientId);

    List<Prescription> findByFilled(Boolean filled);

    Optional<Prescription> findById(Long prescriptionId);

    List<Prescription> findByDate(Date date);
}