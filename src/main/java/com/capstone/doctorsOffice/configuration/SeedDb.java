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
        Date date2 = new Date();

        String timeString = "10:00:00";
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date parsedTime = format.parse(timeString);
        java.sql.Time time = new java.sql.Time(parsedTime.getTime());

        Doctor doctor1 = new Doctor("Lyndon Mathis", "Cardiologist");
        doctorRespository.save(doctor1);

        Patient patient1 = new Patient(null, "Hamish Moore", "1@test.com", "123", "123 Street, Denver - CO", doctor1,null);
        patientRepository.save(patient1);

        Appointment appointment1 = new Appointment(null, null, null, null, null);
        appointment1.setDoctor(doctor1);
        appointment1.setPatient(patient1);
        appointmentRepository.save(appointment1);

//        Appointment appointment = new Appointment();
//        appointment.setDay(date);
//        appointment.setTime(time);
//        appointment.setPatient(patient1);
//        appointment.setDoctor(doctor1);
//
//        appointmentRepository.save(appointment);


        Prescription prescription1 = new Prescription(null, "Amiodarone - 3mg, 2x day", true, date, patient1, doctor1);
        prescriptionRepository.save(prescription1);
    }
}
