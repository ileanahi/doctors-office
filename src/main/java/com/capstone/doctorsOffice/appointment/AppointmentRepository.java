package com.capstone.doctorsOffice.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appoinment, Long>{
    List<Appointment> findByDoctorId(Long doctorId); //instead of just Long id
    List<Appointment> findByPatientId(Long patientId);
}