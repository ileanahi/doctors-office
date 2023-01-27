package com.capstone.doctorsOffice.repositories;

import com.capstone.doctorsOffice.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    List<Appointment> findByDoctorId(Long doctorId); //instead of just Long id
    List<Appointment> findByPatientId(Long patientId);
}