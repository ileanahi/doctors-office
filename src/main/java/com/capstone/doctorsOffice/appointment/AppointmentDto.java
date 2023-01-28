package com.capstone.doctorsOffice.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto implements Serializable {
    private Long appointmentId;
    private Date day;
    private Time time;
    private DoctorDto doctorDto;
    private PatientDto patientDto;

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
    }
}
