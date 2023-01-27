package com.capstone.doctorsOffice.entities;

import com.capstone.doctorsOffice.dtos.PatientDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToOne(mappedBy = "patient")
    private Appointment appointment;

    public Patient (PatientDto patientDto){
        if (patientDto.getName() != null) {
            this.name = patientDto.getName();
        }
        if (patientDto.getAddress() != null) {
            this.address = patientDto.getAddress();
        }
    }
}
