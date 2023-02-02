package com.capstone.doctorsOffice.entities;

import com.capstone.doctorsOffice.dtos.PatientDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    private String name;
    private String password;
    private String address;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name="appointmentId")
    private Appointment appointment;

    public Patient (PatientDto patientDto){
        if (patientDto.getName() != null) {
            this.name = patientDto.getName();
        }
        if (patientDto.getPassword() != null) {
            this.password = patientDto.getPassword();
        }
        if (patientDto.getAddress() != null) {
            this.address = patientDto.getAddress();
        }
    }
}
