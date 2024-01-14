package com.turnero.turnero.access.dto.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDto {
	
	 
	private String email;
	private String password;
	private String passwordConfirm;
	private boolean active;
	private Date createdAp;
	private Date updatedAp;
	private int rolUser;
	private int personId;

}
