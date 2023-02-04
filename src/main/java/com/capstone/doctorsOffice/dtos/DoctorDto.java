package com.capstone.doctorsOffice.dtos;

import com.capstone.doctorsOffice.entities.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto implements Serializable {
    private Long id;

    private String name;

    private String profession;


    private AppointmentDto appointmentDto;


    public DoctorDto(Doctor doctor) {
        if (doctor.getId() != null) {
            this.id = doctor.getId();
        }
        if (doctor.getName() != null) {
            this.name = doctor.getName();
        }
        if (doctor.getProfession() != null) {
            this.profession = doctor.getProfession();
        }
    }
}
