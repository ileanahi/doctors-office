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
    private Long id;
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    private String phone;
    private String password;
    private String address;

    @ManyToOne
    @JoinColumn(name="doctor_id", nullable = false)
    private Doctor doctor;

    @OneToOne
    private Appointment appointment;

    public Patient (PatientDto patientDto){
        if (patientDto.getName() != null) {
            this.name = patientDto.getName();
        }
        if (patientDto.getEmail() != null) {
            this.email = patientDto.getEmail();
        }
        if (patientDto.getPhone() != null) {
            this.phone = patientDto.getPhone();
        }
        if (patientDto.getPassword() != null) {
            this.password = patientDto.getPassword();
        }
        if (patientDto.getAddress() != null) {
            this.address = patientDto.getAddress();
        }
        if (patientDto.getDoctor() != null) {
            this.doctor = patientDto.getDoctor();
        }

    }
}
