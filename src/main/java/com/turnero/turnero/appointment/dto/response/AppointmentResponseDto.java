package com.turnero.turnero.appointment.dto.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentResponseDto {
	
	private int appointmentId;
	
	private Date createdAp;
	
	private Date updatedAp;
 
	private boolean deleted;
	 
	private Date dateAppointment;

	private int  patient;
 
	private int personalDoctor;

	private int shiftClassificationId;
	
	private int shiftStatusId;

}
