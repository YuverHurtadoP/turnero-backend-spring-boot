package com.turnero.turnero.appointment.dto.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentRequestDto {

	private Date dateAppointment;

	private int patient;

	private int personalDoctor;

	private int shiftClassificationId;

	private int shiftStatusId;

}
