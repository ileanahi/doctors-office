package com.capstone.doctorsOffice.dtos;

import com.capstone.doctorsOffice.entities.Patient;
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
    private String password;
    private String address;


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
        if (patient.getPassword() != null){
            this.password = patient.getPassword();
        }
        if (patient.getAddress() != null){
            this.address = patient.getAddress();
        }
    }


}
