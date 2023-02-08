package com.capstone.doctorsOffice.entities;

import java.util.Date;
import jakarta.persistence.*;

import com.capstone.doctorsOffice.dtos.PrescriptionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "prescription")
@Data
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

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    public Prescription(PrescriptionDto prescriptionDto) {
        if (prescriptionDto.getId() != null) {
            this.id = prescriptionDto.getId();
        }
        if (prescriptionDto.getPrescription() != null) {
            this.prescription = prescriptionDto.getPrescription();
        }
        if (prescriptionDto.getFilled() != null) {
            this.filled = prescriptionDto.getFilled();
        }
        if (prescriptionDto.getDate() != null) {
            this.date = prescriptionDto.getDate();
        }
    }
}
