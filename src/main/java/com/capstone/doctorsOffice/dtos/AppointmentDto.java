package com.capstone.doctorsOffice.dtos;

import com.capstone.doctorsOffice.entities.Appointment;

import lombok.*;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto implements Serializable{
    private Long appointmentId;
    private String day;
    private String time;

    private Long doctorId;

    private Long patientId;


    public AppointmentDto(Appointment appointment){
        if (appointment.getAppointmentId() != null){
            this.appointmentId = appointment.getAppointmentId();
        }

        if (appointment.getDay() != null){
            this.day = appointment.getDay();
        }

        if (appointment.getTime() != null){
            this.time = appointment.getTime();
        }

        if (appointment.getDoctor() != null){
            this.doctorId = appointment.getDoctor().getId();
        }

        if (appointment.getPatient() != null){
            this.patientId = appointment.getPatient().getId();
        }
    }
}
