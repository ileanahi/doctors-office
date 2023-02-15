package com.capstone.doctorsOffice.controllers;

import com.capstone.doctorsOffice.dtos.DoctorDto;
import com.capstone.doctorsOffice.dtos.PatientDto;
import com.capstone.doctorsOffice.entities.Appointment;
import com.capstone.doctorsOffice.entities.Prescription;
import com.capstone.doctorsOffice.repositories.AppointmentRepository;
import com.capstone.doctorsOffice.repositories.PrescriptionRepository;
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
@RequestMapping("patientView")
public class PatientViewController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/{id}")
    public String getPatientById(@PathVariable Long id, Model model) throws ChangeSetPersister.NotFoundException {

        Optional<PatientDto> patient = patientService.getPatientById(id);
        List<Prescription> prescriptions = prescriptionRepository.findByPatientId(id);
        List<Appointment> appointments = appointmentRepository.findByPatientId(id);

        model.addAttribute("patient", patient);
        model.addAttribute("prescriptions", prescriptions);
        model.addAttribute("appointments", appointments);

        return "patient-profile";
    }


    @GetMapping("/register")
    public String getDoctorsRegister(Model model) {
        List<DoctorDto> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);
        return "register";
    }


}
