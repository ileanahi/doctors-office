package com.capstone.doctorsOffice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentCreateDto {
    //    private Long appointmentId;
//    private String day;
//    private String time;

    private Long doctorId;

    private Long patientId;

}
