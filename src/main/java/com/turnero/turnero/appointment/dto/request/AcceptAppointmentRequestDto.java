package com.turnero.turnero.appointment.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcceptAppointmentRequestDto {
	@NotNull(message = "El id de la cita no puede estar en blanco")
	private  int appointmentId;
	
	@NotNull(message = "El id del personal medico no puede estar en blanco")
	private int personalMedicalId;
	
	@NotNull(message = "La fecha para la cita no puede estar en blanco")
	private Date dateAppointment;

}
