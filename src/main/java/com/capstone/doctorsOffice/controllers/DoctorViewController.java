package com.capstone.doctorsOffice.controllers;

import com.capstone.doctorsOffice.dtos.DoctorDto;
import com.capstone.doctorsOffice.dtos.PatientDto;
import com.capstone.doctorsOffice.entities.Appointment;
import com.capstone.doctorsOffice.entities.Patient;
import com.capstone.doctorsOffice.entities.Prescription;
import com.capstone.doctorsOffice.repositories.AppointmentRepository;
import com.capstone.doctorsOffice.repositories.PatientRepository;
import com.capstone.doctorsOffice.services.DoctorService;
import com.capstone.doctorsOffice.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.ui.Model;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;


@ComponentScan
@Controller
@RequestMapping("doctorView")
public class DoctorViewController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/{id}")
    public String getDoctorById(@PathVariable Long id, Model model) throws ChangeSetPersister.NotFoundException {
        System.out.println("**************** doctor view!!! ** -------------------");

        Optional<DoctorDto> doctor = doctorService.getDoctorById(id);
        System.out.println("**************** DOCTOR:");
        System.out.println(doctor);

        List<Patient> patients = patientRepository.findByDoctorId(id);
        System.out.println("**************** PATIENTS:");
        System.out.println(patients);

        List<Appointment> appointments = appointmentRepository.findByDoctorId(id);
        System.out.println("**************** APPOINTMENTS: ");
        System.out.println(appointments);


        model.addAttribute("doctor", doctor);
        model.addAttribute("patients", patients);
        model.addAttribute("appointments", appointments);

        return "doctor-profile";
    }

    @GetMapping("/")
    public String getDoctors(Model model) {
        System.out.println("**************** DOCTORS ********************************");

        List<DoctorDto> doctors = doctorService.getAllDoctors();
        System.out.println("**************** DOCTORS LIST ********************************");
        System.out.println(doctors);

        model.addAttribute("doctors", doctors);

        return "/doctors";
    }

}
