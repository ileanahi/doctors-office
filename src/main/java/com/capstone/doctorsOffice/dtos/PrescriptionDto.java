package com.capstone.doctorsOffice.dtos;

import java.io.Serializable;
import java.util.Date;

import com.capstone.doctorsOffice.entities.Prescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionDto implements Serializable {
    private Long id;
    private String prescription;
    private Boolean filled;
    private Date date;

    public PrescriptionDto(Prescription prescription){
        if (prescription.getId() != null){
            this.id = prescription.getId();
        }

        if (prescription.getPrescription() != null){
            this.prescription = prescription.getPrescription();
        }

        if (prescription.getFilled() != null){
            this.filled = prescription.getFilled();
        }

        if (prescription.getDate() != null){
            this.date = prescription.getDate();
        }
    }
}
