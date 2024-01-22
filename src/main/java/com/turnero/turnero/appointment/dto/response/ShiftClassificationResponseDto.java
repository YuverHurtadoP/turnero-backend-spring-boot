package com.turnero.turnero.appointment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShiftClassificationResponseDto {
	
	private int shiftClassificationId;
	
	private String description;
	
	private boolean active;

	private boolean deleted;

}
