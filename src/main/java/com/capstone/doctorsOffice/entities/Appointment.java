package com.capstone.doctorsOffice.entities;

import com.capstone.doctorsOffice.dtos.AppointmentDto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @Temporal(TemporalType.DATE)
    private Date day;

    @Temporal(TemporalType.TIME)
    private Time time;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Appointment(Date day, Time time) {
        this.day = day;
        this.time = time;
    }

    public Appointment(AppointmentDto appointmentDto){
        if (appointmentDto.getAppointmentId() != null){
            this.appointmentId = appointmentDto.getAppointmentId();;
        }

        if (appointmentDto.getDay() != null){
            this.day = appointmentDto.getDay();;
        }

        if (appointmentDto.getTime() != null){
            this.time = appointmentDto.getTime();;
        }
    }
}
