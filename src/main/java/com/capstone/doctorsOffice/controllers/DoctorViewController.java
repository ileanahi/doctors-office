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

    @GetMapping("/{id}")
    public String getDoctorById(@PathVariable Long id, Model model) throws ChangeSetPersister.NotFoundException {
        Optional<DoctorDto> doctor = doctorService.getDoctorById(id);
        model.addAttribute("doctor", doctor);
        return "doctor-profile";
    }

    @GetMapping("")
    public String getDoctors(Model model) {
        List<DoctorDto> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);

        return "/doctors";
    }

}
