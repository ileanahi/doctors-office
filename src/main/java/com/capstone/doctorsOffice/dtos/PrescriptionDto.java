package com.capstone.doctorsOffice.dtos;


import com.capstone.doctorsOffice.entities.Prescription;

import javax.persistence.Temporal;
import java.io.Serializable;
import java.util.Date;

public class PrescriptionDto implements Serializable {
    private Long id;
    private String prescription;
    public Boolean filled;

    private Date date;

    public PrescriptionDto(Prescription prescription){
        if (prescription.getId() != null){
            this.id = prescription.getId();
        }

        if (prescription.getPrescription() != null){
            this.prescription = prescription.getPrescription();
        }

        if (prescription.getFilled() != Boolean.FALSE){
            this.filled = prescription.getFilled();
        }
        if (prescription.getDate() != null) {
            this.date = prescription.getDate();

        }
    }

}
