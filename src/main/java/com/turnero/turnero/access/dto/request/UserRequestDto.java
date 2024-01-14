package com.turnero.turnero.access.dto.request;

import java.util.Date;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDto {

	@NotBlank(message = "El email no puede estar en blanco")
	@Email(message = "El formato del correo electrónico no es válido")
	private String email;

	@NotBlank(message = "La clave no puede estar en blanco")
	private String password;

	@NotBlank(message = "La Confirmación de la clave no puede estar en blanco")
	private String passwordConfirm;
	private boolean active;
	private Date createdAp;
	private Date updatedAp;

	@NotNull(message = "El rol no puede estar en blanco")
	private int rolUser;
	private int personId;

	

}
