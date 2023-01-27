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
    private String address;

    //Doctor ID   - many to one?

    //Appointment ID   -one to one


    public PatientDto(Patient patient) {

        if (patient.getId() != null){
            this.id = patient.getId();
        }
        if (patient.getName() != null){
            this.name = patient.getName();
        }
        if (patient.getAddress() != null){
            this.address = patient.getAddress();
        }
    }
}
