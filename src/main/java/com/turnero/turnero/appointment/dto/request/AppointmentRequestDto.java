package com.turnero.turnero.appointment.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentRequestDto {


	@NotNull(message = "El id del paciente no puede estar en blanco")
	private int patient; 
 
	@NotNull(message = "El id de la clasificacion no puede estar en blanco")
	private int shiftClassificationId;
	

}
