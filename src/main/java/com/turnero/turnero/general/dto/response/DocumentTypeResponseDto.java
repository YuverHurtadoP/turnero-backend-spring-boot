package com.turnero.turnero.general.dto.response;

 

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentTypeResponseDto {
	private int documentTypeId;

	private String description;
}
