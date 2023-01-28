package com.capstone.docctorsOffice.repositories;

import com.capstone.docctorsOffice.entities.Doctor;
import com.capstone.doctorsOffice.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
    Optional<Doctor> findById(Long doctorId);

    @Repository
    interface AppointmentRepository extends JpaRepository<Appoinment, Long>{
        List<Appointment> findByDoctorId(Long doctorId); //instead of just Long id
        List<Appointment> findByPatientId(Long patientId);
    }
}