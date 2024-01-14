package com.turnero.turnero.person.dto.request;

import java.util.Date;

import com.turnero.turnero.access.dto.request.UserRequestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonRequestDto {
	
 
	private String name;

	private String lastName;

	private String nroDni;

	private String phoneNumber;

	private boolean active;

	private Date createdAp;

	private Date updatedAp;
	
	private int municipalityId;
	
	private int documentTypeId;
	
	private UserRequestDto userRequestDto;

}
