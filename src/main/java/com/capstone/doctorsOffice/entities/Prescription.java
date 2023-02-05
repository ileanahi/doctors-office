package com.capstone.doctorsOffice.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.capstone.doctorsOffice.dtos.PrescriptionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "prescription")
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prescription;

    private Boolean filled;


    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToMany(mappedBy = "prescription")
    private Set<Prescription> patients;

    public Prescription (Date date) {
        this.date = date;
    }

//    public Prescription(PrescriptionDto prescriptionDto) {
//        if (prescriptionDto.getPrescriptionId != null) {
//            this.id = prescriptionDto.getPrescriptionId();
//        }
//        if (prescriptionDto.getPrescription != null) {
//            this.prescription = prescriptionDto.getPrescription();
//        }
//        if (prescriptionDto.getFilled != null) {
//            this.filled = prescriptionDto.getFilled();
//        }
//        if (PrescriptionDto.getDate != null) {
//            this.date = prescriptionDto.getDate();
//        }
//    }
}
