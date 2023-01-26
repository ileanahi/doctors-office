package com.capstone.docctorsOffice.repositories;

import com.capstone.docctorsOffice.entities.Appoinment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appoinment, Long>{
    List<Appointment> findByDoctorId(Long doctorId); //instead of just Long id
    List<Appointment> findByPatientId(Long patientId);
}