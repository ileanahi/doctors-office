package com.capstone.doctorsOffice.controllers;

import com.capstone.doctorsOffice.dtos.PatientDto;
import com.capstone.doctorsOffice.dtos.PrescriptionDto;
import com.capstone.doctorsOffice.services.PatientService;
import com.capstone.doctorsOffice.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@ComponentScan
@Controller
@RequestMapping("patientView")
public class PrescriptionViewController {

    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private PatientService patientService;

    @GetMapping("/{id}")
    public String getPrescriptionById(@PathVariable Long id, Model model) throws ChangeSetPersister.NotFoundException {

        List<PrescriptionDto> prescription = prescriptionService.getAllPrescriptions();


//        Optional<PatientDto> patient = patientService.getPatientById(id);


        model.addAttribute("prescriptions", prescription);
//        model.addAttribute("patient", patient);

        return "PharmacyForm";
    }
}
