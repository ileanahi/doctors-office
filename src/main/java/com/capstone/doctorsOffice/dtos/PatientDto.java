package com.capstone.doctorsOffice.dtos;

import com.capstone.doctorsOffice.entities.Doctor;
import com.capstone.doctorsOffice.entities.Patient;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto implements Serializable {

    private Long id;
    private String name;
    private String password;
    private String address;


    public PatientDto(Patient patient) {

        if (patient.getPatientId() != null){
            this.id = patient.getPatientId();
        }
        if (patient.getName() != null){
            this.name = patient.getName();
        }
        if (patient.getPassword() != null){
            this.password = patient.getPassword();
        }
        if (patient.getAddress() != null){
            this.address = patient.getAddress();
        }
    }


}
