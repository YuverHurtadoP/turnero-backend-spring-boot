package com.turnero.turnero.person.dto.request;

import java.util.Date;

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
public class PersonUpdateRequestDto{
	
	@NotNull(message = "El ID de la persona no puede estar en blanco")
    private Integer personId;
	
	@NotBlank(message = "El nombre no puede estar en blanco")
	private String name;

	@NotBlank(message = "El apellido no puede estar en blanco")
	private String lastName;


	@Pattern(regexp = "\\d{10}", message = "El número de teléfono debe tener 10 dígitos")
	private String phoneNumber;


	private Date updatedAp;
	
	@NotNull(message = "El muncipio no puede estar en blanco")
	private int municipalityId;
	
	@NotNull(message = "El tipo de documento no puede estar en blanco")
	private int documentTypeId;
	
}
