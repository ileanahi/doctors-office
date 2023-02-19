package com.capstone.doctorsOffice.controllers;

import com.capstone.doctorsOffice.entities.Doctor;
import com.capstone.doctorsOffice.entities.Patient;
import com.capstone.doctorsOffice.repositories.AppointmentRepository;
import com.capstone.doctorsOffice.repositories.DoctorRepository;
import com.capstone.doctorsOffice.repositories.PatientRepository;
import com.capstone.doctorsOffice.services.AppointmentService;
import com.capstone.doctorsOffice.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;


    @GetMapping("/{patientId}/{doctorId}/newAppointment")
    public String showAppointmentRequestForm(@PathVariable Long patientId, @PathVariable Long doctorId, Model model){
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
        model.addAttribute("patient", patientOptional);
        model.addAttribute("doctor", doctorOptional);
        return "newAppointment";
    }

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