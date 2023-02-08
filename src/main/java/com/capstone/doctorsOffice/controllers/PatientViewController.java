package com.capstone.doctorsOffice.controllers;

import com.capstone.doctorsOffice.dtos.PatientDto;
import com.capstone.doctorsOffice.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;


@ComponentScan
@Controller
@RequestMapping("patientView")
public class PatientViewController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/{id}")
    public String getPatientById(@PathVariable Long id, Model model) {
        System.out.println("patient view ");
        System.out.println(patientService.getPatientById(id).getClass());

        Optional<PatientDto> patient = patientService.getPatientById(id);
        System.out.println(patient);
        model.addAttribute("patient", patient);
        return "patient-profile";
    }
//    @GetMapping("/{id}")
//    public void getPatientById(@PathVariable Long id, Model model){
//        System.out.println(id);
//        System.out.println("-------------------------------------------------------------");


//    }


}
