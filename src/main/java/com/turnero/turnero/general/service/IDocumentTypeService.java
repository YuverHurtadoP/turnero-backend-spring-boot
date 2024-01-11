package com.turnero.turnero.general.service;

import java.util.List;

import com.turnero.turnero.general.dto.response.DocumentTypeResponseDto;

public interface IDocumentTypeService {
	
	public List<DocumentTypeResponseDto> documentTypeList();
}
