package com.capstone.doctorsOffice.dtos;

import com.capstone.doctorsOffice.entities.Doctor;
import com.capstone.doctorsOffice.entities.Patient;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String phone;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String address;

    private Doctor doctor;


    public PatientDto(Patient patient) {

        if (patient.getId() != null){
            this.id = patient.getId();
        }
        if (patient.getName() != null){
            this.name = patient.getName();
        }
        if (patient.getEmail() != null){
            this.email = patient.getEmail();
        }
        if (patient.getPhone() != null){
            this.phone = patient.getPhone();
        }
        if (patient.getPassword() != null){
            this.password = patient.getPassword();
        }
        if (patient.getAddress() != null){
            this.address = patient.getAddress();
        }
        if(patient.getDoctor() != null){
            this.doctor = patient.getDoctor();
        }
    }


}
