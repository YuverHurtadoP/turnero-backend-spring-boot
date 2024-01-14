package com.turnero.turnero.access.dto.Response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
	private String email;
	private boolean active;
	private Date createdAp;
	private Date updatedAp;
	private int rolUser;
	private int personId;
}
