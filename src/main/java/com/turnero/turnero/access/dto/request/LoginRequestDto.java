package com.turnero.turnero.access.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
	@NotBlank(message = "El email no puede estar en blanco")
	@Email(message = "El formato del correo electrónico no es válido")
	 private String username;
	
	@NotBlank(message = "La clave no puede estar en blanco")
	 private String password;
}
