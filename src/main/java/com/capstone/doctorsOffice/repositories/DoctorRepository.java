package com.capstone.docctorsOffice.repositories;

import com.capstone.docctorsOffice.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
    Optional<Doctor> findById(Long doctorId);
}