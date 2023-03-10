package com.capstone.doctorsOffice.repositories;
import com.capstone.doctorsOffice.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
    Optional<Patient> findById(Long patientId);
    Optional<Patient> findByEmail(String email);
    List<Patient> findByDoctorId(Long id);
}