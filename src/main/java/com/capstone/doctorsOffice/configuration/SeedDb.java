package com.capstone.doctorsOffice.configuration;

import com.capstone.doctorsOffice.entities.Appointment;
import com.capstone.doctorsOffice.entities.Doctor;
import com.capstone.doctorsOffice.entities.Patient;
import com.capstone.doctorsOffice.entities.Prescription;
import com.capstone.doctorsOffice.repositories.AppointmentRepository;
import com.capstone.doctorsOffice.repositories.DoctorRepository;
import com.capstone.doctorsOffice.repositories.PatientRepository;
import com.capstone.doctorsOffice.repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class SeedDb implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRespository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    public void run(String ... args) throws Exception {

        Date date = new Date();

        String timeString = "10:00:00";
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date parsedTime = format.parse(timeString);
        java.sql.Time time = new java.sql.Time(parsedTime.getTime());

        Doctor doctor1 = new Doctor("Doctor", "Doctor");
        doctorRespository.save(doctor1);

        Patient patient1 = new Patient(null, "Rafaela", "1@test.com", "123", "123 Street", doctor1,null);
        patientRepository.save(patient1);

        Appointment appointment1 = new Appointment(null, date, time, patient1, doctor1);
        appointment1.setDoctor(doctor1);
        appointmentRepository.save(appointment1);

        Prescription prescription1 = new Prescription(null, "prescription name", true, date, patient1, doctor1);
        prescriptionRepository.save(prescription1);
    }
}
