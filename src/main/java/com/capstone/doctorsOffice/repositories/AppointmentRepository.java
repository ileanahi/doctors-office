package com.capstone.doctorsOffice.repositories;

import com.capstone.doctorsOffice.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    List<Appointment> findByDoctorId(Long id);
    List<Appointment> findByPatientId(Long patientId);
}
