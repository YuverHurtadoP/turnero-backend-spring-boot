package com.turnero.turnero.person.dto.request;

import java.util.Date;

import com.turnero.turnero.access.dto.request.UserRequestDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonRequestDto {
	
	@NotBlank(message = "El nombre no puede estar en blanco")
	private String name;

	@NotBlank(message = "El apellido no puede estar en blanco")
	private String lastName;

	@NotBlank(message = "El DNI no puede estar en blanco")
	private String nroDni;

	@Pattern(regexp = "\\d{10}", message = "El número de teléfono debe tener 10 dígitos")
	private String phoneNumber;

	private boolean active;

	private Date createdAp;

	private Date updatedAp;
	
	@NotNull(message = "El muncipio no puede estar en blanco")
	private int municipalityId;
	
	private int documentTypeId;
	
	@Valid
	private UserRequestDto userRequestDto;

}
