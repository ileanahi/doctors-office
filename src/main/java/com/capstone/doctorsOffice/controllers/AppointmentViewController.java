package com.capstone.doctorsOffice.controllers;

import com.capstone.doctorsOffice.dtos.AppointmentDto;
import com.capstone.doctorsOffice.dtos.PatientDto;
import com.capstone.doctorsOffice.entities.Appointment;
import com.capstone.doctorsOffice.entities.Prescription;
import com.capstone.doctorsOffice.repositories.AppointmentRepository;
import com.capstone.doctorsOffice.repositories.PrescriptionRepository;
import com.capstone.doctorsOffice.services.AppointmentService;
import com.capstone.doctorsOffice.services.PatientService;
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
@RequestMapping("appointmentView")
public class AppointmentViewController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentRepository appointmentRepository;

//   @Autowired
//   @GetMapping("/{id}")
//    public String getAppointmentByPatientId(@PathVariable Long id, Model model) throws ChangeSetPersister.NotFoundException {
//       Optional<PatientDto> patientDtoOptional = patientService.getPatientById(id);
//       if (patientDtoOptional.isPresent()) {
//           List<AppointmentDto> appointmentDtoList = appointmentRepository.findByPatientId(id).stream().map(entity -> {
//               return new AppointmentDto(entity);
//           }).toList();
//           model.addAttribute("appointments", appointmentDtoList);
//       }
//
//        return "appointments";
//    }

}
